package controller;

import java.awt.print.PrinterJob;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.cert.X509Certificate;
import javax.swing.JTextArea;
import javax.swing.RepaintManager;
import javax.ws.rs.core.MediaType;

import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import com.sun.jersey.core.util.MultivaluedMapImpl;


public class PrintPage implements Printable {
 
    private Component print_component;
 
    public static void main(String args[]) {
      //  new PrintPage(new JTextArea("hi my name is pankaj how r u")).doPrint();
    	System.out.print(new PrintPage().postClient());
    	
    	
    }
 
    @Value("${clientUrl}")
	private String clientUrl;
 
    public void doPrint() {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(this);
        if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException pe) {
                System.out.println("Error printing: " + pe);
            }
        }
    }
 
    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return (NO_SUCH_PAGE);
        } else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            disableDoubleBuffering(print_component);
            print_component.paint(g2d);
            enableDoubleBuffering(print_component);
            return (PAGE_EXISTS);
        }
    }
 
    public static void disableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(false);
    }
 
    public static void enableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(true);
    }
    
    
    
    public String postClient() {
	String response=null;
		try {

		

			//SSLContext context = SSLContext.getInstance("TLS");
		//	context.init(null, trustAllCerts, new SecureRandom());
		//	HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

			ClientConfig config = new DefaultClientConfig();

		
			com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);

			String t1="{\r\n" + "\"username\":\"9413387309\",  \r\n" + 
			"\"amount\":533,\r\n" + 
			"\"orderId\":\"19267by\",\r\n" + 
			"\"externalRef2\":\"\",\r\n" + 
			"\"externalRef3\":\"\",\r\n" + 
			"\"customerMobile\":\"8107357705\"\r\n" + 
			"}\r\n" + 
			"";

			/*MultivaluedMapImpl formData = new MultivaluedMapImpl();
			formData.add("username", "9413387309");
			formData.add("amount", "1.1");
			formData.add("orderId", "mm138");
			formData.add("externalRef2", "Ankit");
			formData.add("externalRef3", "Mobile");
			formData.add("customerMobile", "9717215040");*/

		
			StringEntity entity = null;
			client.setFollowRedirects(true);
			
			WebResource resource = client.resource(clientUrl);
			ClientResponse responseFrom = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,
					t1);
			response = responseFrom.getEntity(String.class);
			
			 System.out.println(responseFrom.getEntity(String.class));
			// " + responseFrom.getStatus());

			return response;

		} catch (Exception e) {

			e.printStackTrace();
			return response;
		}
	}
}
