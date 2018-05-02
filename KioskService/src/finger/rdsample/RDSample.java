package finger.rdsample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;


import finger.model.*;
import finger.request.RDInterface;
import finger.request.RDService;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

@SuppressWarnings("deprecation")
public class RDSample {

	private String primaryUrl = "http://127.0.0.1:";
	private Serializer serializable;
	private ArrayList<RDService> services;
	private String timoutValues[] =  { "10000", "20000", "30000", "40000", "50000",
			"60000", "70000", "80000", "90000", "100000", "0" };
	private String envValues[] = { "S", "PP", "P" };

	private String deviceInfoVerb = "DEVICEINFO";
	private String deviceInfopath = "";
	private String captureVerb = "CAPTURE";
	private String capturepath = "";
	private boolean isRDFound= false;


	private String MygetPIDOptions() {
        try {
            Opts opts = new Opts();
            opts.fCount = "1";
            opts.fType = "0";
            opts.iCount = "0";
            opts.iType = "0";
            opts.pCount = "0";
            opts.pType = "0";
            opts.format = "0";
            opts.pidVer = "2.0";
            opts.timeout =timoutValues[0];
            opts.posh = "UNKNOWN";
            opts.env = envValues[0];

            PidOptions pidOptions = new PidOptions();
            pidOptions.ver = "2.0";            
            pidOptions.Opts = opts;

            StringWriter writer = new StringWriter();
            serializable.write(pidOptions, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@SuppressWarnings("resource")
	public boolean MyDiscoverRDService(String strRDName) 
	{		
		serializable = new Persister();
		services = new ArrayList<RDService>();
		
		for (int i = 11100; i <= 11120; i++) {		

			try {
				RequestBuilder builder = RequestBuilder.create("RDSERVICE");
				builder.setUri(primaryUrl + i);
				HttpUriRequest request = builder.build();
				HttpClient client = new DefaultHttpClient();
				HttpResponse response = client.execute(request);

				BufferedReader rd = new BufferedReader(
						new InputStreamReader(response.getEntity()
								.getContent()));

				String line = null;
				String res = "";
				while ((line = rd.readLine()) != null) {
					res += line;
				}
				
				RDService rdService = serializable.read(RDService.class,
						res);
				rd.close();
				if (rdService.info.contains(strRDName)) //Found
				{
					isRDFound = true;					
					List<RDInterface> rdInterface = rdService.rdInterface;
					for (int j = 0; j < rdInterface.size(); j++) {
						RDInterface rdf = rdInterface.get(j);
						if (rdf.id.equals(captureVerb)) {
							capturepath = rdf.path;
						} else if (rdf.id.equals(deviceInfoVerb)) {
							deviceInfopath = rdf.path;
						}
					}
					rdService.port = i;
					services.add(rdService);
					break;
				}				
				
				
			} catch (Exception e) {
				//System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return isRDFound;
	}
	
	@SuppressWarnings("resource")
	public String MyDeviceInfo() 
	{
		String strResponse="";
		
		if (isRDFound) 
		{			
			try {		
				
				RDService rdService = services.get(0);
				RequestBuilder builder = RequestBuilder.create(deviceInfoVerb);
				builder.setUri(primaryUrl + rdService.port + deviceInfopath);
				builder.setHeader("Content-Type", "text/xml");
				builder.setHeader("Content-Length", "0");

				HttpUriRequest request = builder.build();
				HttpClient client = new DefaultHttpClient();
				HttpResponse response = client.execute(request);

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));

				String line = null;
				String res = "";
				while ((line = rd.readLine()) != null) {
					res += line;
				}				

				strResponse = res.toString();
				rd.close();
			} catch (Exception e) {
				e.printStackTrace();				
			}
		}
		
		return strResponse;
	} 

	@SuppressWarnings("resource")
	public String MyFingerCapture() 
	{
		String strResponse="";
		if (isRDFound) 
		{		
		
			try {
				String pidOptions = MygetPIDOptions();
				RDService rdService = services.get(0);
				RequestBuilder builder = RequestBuilder.create(captureVerb);
				builder.setUri(primaryUrl + rdService.port + capturepath);
				builder.setHeader("Content-Type", "text/xml");
				
				HttpUriRequest request = builder
						.setEntity(new ByteArrayEntity(pidOptions.getBytes("UTF-8"))).build();
				@SuppressWarnings("resource")
				HttpClient client = new DefaultHttpClient();
				HttpResponse response = client.execute(request);
	
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
	
				String line = null;
				String res = "";
				while ((line = rd.readLine()) != null) {
					res += line;
				}
				strResponse = res.toString();				
				rd.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		
		return strResponse;
	}
	
}
