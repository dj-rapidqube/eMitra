package UidotpAuthentication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
 *
 * @author ACPL
 */
public class Encrypter {

    private static final String JCE_PROVIDER = "BC";
    public static final int IV_SIZE_BITS = 96;

    // Additional authentication data - last 128 bits of ISO format timestamp
    public static final int AAD_SIZE_BITS = 128;

    // Authentication tag length - in bits
    public static final int AUTH_TAG_SIZE_BITS = 128;

    private static final String ASYMMETRIC_ALGO = "RSA/ECB/PKCS1Padding";
    private static final int SYMMETRIC_KEY_SIZE = 256;

    private static final String CERTIFICATE_TYPE = "X.509";

    private PublicKey publicKey;
    private Date certExpiryDate;

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public Encrypter(String publicKeyFileName) {
        FileInputStream fileInputStream = null;
        try {
            CertificateFactory certFactory = CertificateFactory.getInstance(CERTIFICATE_TYPE, JCE_PROVIDER);
            fileInputStream = new FileInputStream(new File(publicKeyFileName));
            X509Certificate cert = (X509Certificate) certFactory.generateCertificate(fileInputStream);
            publicKey = cert.getPublicKey();
            certExpiryDate = cert.getNotAfter();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @SuppressWarnings("unused")
	private String getCurrentISOTimeInUTF8() {
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss");
        String timeNow = df.format(new Date());
        return timeNow;
    }

    public byte[] generateSessionKey() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES", JCE_PROVIDER);
        kgen.init(SYMMETRIC_KEY_SIZE);
        SecretKey key = kgen.generateKey();
        byte[] symmKey = key.getEncoded();
        return symmKey;
    }

    public byte[] encryptUsingPublicKey(byte[] data) throws IOException, GeneralSecurityException {
        // encrypt the session key with the public key
        Cipher pkCipher = Cipher.getInstance(ASYMMETRIC_ALGO, JCE_PROVIDER);
        pkCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encSessionKey = pkCipher.doFinal(data);
        return encSessionKey;
    }

    public byte[] encryptUsingSessionKey(byte[] skey, byte[] data, String tStamp) throws InvalidCipherTextException {
        byte[] tsBytes = null;
        try {
            tsBytes = tStamp.getBytes("UTF-8");
            //logger.info(tStamp);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] ivBytes = new byte[IV_SIZE_BITS / 8];
        byte[] aadBytes = new byte[AAD_SIZE_BITS / 8];

        System.arraycopy(tsBytes, tsBytes.length - 12, ivBytes, 0, ivBytes.length);
        System.arraycopy(tsBytes, tsBytes.length - 16, aadBytes, 0, aadBytes.length);

        AEADParameters aeadParam = new AEADParameters(new KeyParameter(skey), AUTH_TAG_SIZE_BITS, ivBytes, aadBytes);
        GCMBlockCipher gcmb = new GCMBlockCipher(new AESEngine());
        gcmb.init(true, aeadParam);
        int outputSize = gcmb.getOutputSize(data.length);
        byte[] result = new byte[outputSize];
        int processLen = gcmb.processBytes(data, 0, data.length, result, 0);
        gcmb.doFinal(result, processLen);
        byte[] packedCipherData = new byte[result.length + tsBytes.length];
        System.arraycopy(tsBytes, 0, packedCipherData, 0, tsBytes.length);
        System.arraycopy(result, 0, packedCipherData, tsBytes.length, result.length);
        
        return packedCipherData;
    }

    public byte[] encryptUsingSessionKeyNoAdd(byte[] skey, byte[] data, String tStamp) throws InvalidCipherTextException {
        byte[] tsBytes = null;
        try {
            tsBytes = tStamp.getBytes("UTF-8");
            //logger.info(tStamp);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] ivBytes = new byte[IV_SIZE_BITS / 8];
        byte[] aadBytes = new byte[AAD_SIZE_BITS / 8];

        System.arraycopy(tsBytes, tsBytes.length - 12, ivBytes, 0, ivBytes.length);
        System.arraycopy(tsBytes, tsBytes.length - 16, aadBytes, 0, aadBytes.length);

        AEADParameters aeadParam = new AEADParameters(new KeyParameter(skey), AUTH_TAG_SIZE_BITS, ivBytes, aadBytes);
        GCMBlockCipher gcmb = new GCMBlockCipher(new AESEngine());
        gcmb.init(true, aeadParam);
        int outputSize = gcmb.getOutputSize(data.length);
        byte[] result = new byte[outputSize];
        int processLen = gcmb.processBytes(data, 0, data.length, result, 0);
        gcmb.doFinal(result, processLen);
        //byte[] packedCipherData = new byte[result.length + tsBytes.length];
        //System.arraycopy(tsBytes, 0, packedCipherData, 0, tsBytes.length);
        //System.arraycopy(result, 0, packedCipherData, tsBytes.length, result.length);
        
        System.out.println(new String(result));
        
        return result;
    }

    public String getCertificateIdentifier() {
        SimpleDateFormat ciDateFormat = new SimpleDateFormat("yyyyMMdd");
        ciDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String certificateIdentifier = ciDateFormat.format(this.certExpiryDate);
        return certificateIdentifier;
    }
}