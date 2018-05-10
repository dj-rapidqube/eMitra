package Client;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;

import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Value;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import com.sun.jersey.core.util.MultivaluedMapImpl;



public class ClientExecution {
	public String response = null;
	
	@Value("${cardPaymentUrl}")
	private String cardPaymentUrl;
	
	@Value("${mgetApplicationsStatusMobile}")
	private String mgetApplicationsStatusMobile;
	
	
	@Value("${getphedTransactionHistory}")
	private String getphedTransactionHistory;
	

	public String postClient(String orderId, String amount, String loginUser) {
		
		
	
		
		
		  System.out.println("Check Order Id "+orderId+"Amount :: " +amount+" User Name : "+loginUser);
		 
		try {

			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

			ClientConfig config = new DefaultClientConfig();

			config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES,
					new HTTPSProperties(new HostnameVerifier() {

						@Override
						public boolean verify(String hostname, SSLSession session) {
							// TODO Auto-generated method stub
							return true;
						}
					}, context));
			com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);

			/*MultivaluedMapImpl formData = new MultivaluedMapImpl();
			formData.add("tokenNumber", token);
			formData.add("dataType", amount);
			formData.add("loggedInUser", loginUser);*/

			StringEntity entity = null;
			client.setFollowRedirects(true);
/*			WebResource resource = client.resource(
					"http://reportsemitraapp.rajasthan.gov.in/emitraReportsRepository/applicationVerification");
			ClientResponse responseFrom = resource.type("application/x-www-form-urlencoded").post(ClientResponse.class,
					entity);
*/
			/*String t1="{\r\n" + "\"username\":\"9413387309\",  \r\n" + 
					"\"amount\":533,\r\n" + 
					"\"orderId\":\"19267by\",\r\n" + 
					"\"externalRef2\":\"\",\r\n" + 
					"\"externalRef3\":\"\",\r\n" + 
					"\"customerMobile\":\"8107357705\"\r\n" + 
					"}\r\n" + 
					"";
			*/
			
			String t1="{\r\n" + "\"username\":\""+loginUser+"\",  \r\n" + 
					"\"amount\":"+amount+",\r\n" + 
					"\"orderId\":\""+orderId+"\",\r\n" + 
					"\"externalRef2\":\"\",\r\n" + 
					"\"externalRef3\":\"\",\r\n" + 
					"\"customerMobile\":\"8107357705\"\r\n" + 
					"}\r\n" + 
					"";
			
			WebResource resource = client
							.resource(cardPaymentUrl);
			ClientResponse responseFrom = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,
							t1);

			response = responseFrom.getEntity(String.class);
			System.out.println("Response :: "+response + " code :: "  + responseFrom.getStatus());
			
			System.out.println("1" + response);
			return response;

		} catch (Exception e) {
			System.out.println("Exception :: "+e.getMessage());
			e.printStackTrace();
			return response;
		}
	}

	public String mgetApplicationsStatusMobile(String receiptNumbe) {
		/*
		 * System.out.println(mid); System.out.println(msisdn);
		 * System.out.println(token);
		 */
		try {

			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

			ClientConfig config = new DefaultClientConfig();

			config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES,
					new HTTPSProperties(new HostnameVerifier() {

						@Override
						public boolean verify(String hostname, SSLSession session) {
							// TODO Auto-generated method stub
							return true;
						}
					}, context));
			com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);

			MultivaluedMapImpl formData = new MultivaluedMapImpl();
			formData.add("receiptNumbe", receiptNumbe);

			StringEntity entity = null;
			client.setFollowRedirects(true);
			WebResource resource = client.resource(mgetApplicationsStatusMobile);
			ClientResponse responseFrom = resource.type("application/x-www-form-urlencoded").post(ClientResponse.class,
					entity);
			response = responseFrom.getEntity(String.class);
			// System.out.println(responseFrom.getEntity(String.class) + " code
			// " + responseFrom.getStatus());
			System.out.println("2" + response);
			return response;

		} catch (Exception e) {

			e.printStackTrace();
			return response;
		}
	}

	public String getPhedTransactionHistory(String consumerKey, String fromDate, String toDate,String srvId) {
		/*
		 * System.out.println(mid); System.out.println(msisdn);
		 * System.out.println(token);
		 */
		try {

			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };

			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

			ClientConfig config = new DefaultClientConfig();

			config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES,
					new HTTPSProperties(new HostnameVerifier() {

						@Override
						public boolean verify(String hostname, SSLSession session) {
							// TODO Auto-generated method stub
							return true;
						}
					}, context));
			com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(config);

			MultivaluedMapImpl formData = new MultivaluedMapImpl();
			formData.add("consumerKey", consumerKey);
			formData.add("srvId", srvId);
			formData.add("fromDate", fromDate);
			formData.add("toDate", toDate);

			StringEntity entity = null;
			client.setFollowRedirects(true);
			WebResource resource = client.resource(getphedTransactionHistory);
			ClientResponse responseFrom = resource.type("application/x-www-form-urlencoded").post(ClientResponse.class,
					entity);
			response = responseFrom.getEntity(String.class);
			// System.out.println(responseFrom.getEntity(String.class) + " code
			// " + responseFrom.getStatus());
			System.out.println("3" + response);
			return response;

		} catch (Exception e) {

			e.printStackTrace();
			return response;
		}
	}
}