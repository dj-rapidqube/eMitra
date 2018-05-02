package dao;


import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Repository;

import model.DBServiceResponse;
import model.DisabilityCertificateInfo;
import model.Login;
import model.QueryDetails;
import utils.DBHTTPUtils;
@Repository("disabilityDAO")
public class DisabilityDAOImpl implements DisabilityDAO {
	
	static final Logger logger = Logger.getLogger(DisabilityDAOImpl.class);
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	
	@Autowired
    private DBHTTPUtils dbHTTPUtils;
	
	@Override
	public String saveDisabilityCertificateDetails(DisabilityCertificateInfo disabilityinfo) {
		
		String transID = null;
		
		try {
            QueryDetails queryDetails = new QueryDetails("Proc_PrintCertificate");
            queryDetails.setAutoCommit(false);

            queryDetails.addQueryParams(1, "Insert");
            queryDetails.addQueryParams(2, disabilityinfo.getAddhaarid());
            queryDetails.addQueryParams(3, 0);
            queryDetails.addQueryParams(4, null);
            queryDetails.addQueryParams(5, Login.SSOID);
            queryDetails.addQueryParams(6, disabilityinfo.getServiceID());
            queryDetails.addQueryParams(7, disabilityinfo.getSubServiceID());
            queryDetails.addQueryParams(8, disabilityinfo.getServiceName());
            queryDetails.addQueryParams(9, disabilityinfo.getSerialNo());
            
            DBServiceResponse serviceResponse = dbHTTPUtils.pullDataFromDBApiServer(queryDetails);
            logger.info("saveDisabilityCertificateDetails , Response:" + serviceResponse.getStatus());
            if (HttpStatus.SC_OK == serviceResponse.getStatus()) {
                JSONArray resultSet = serviceResponse.getJsonArray();
                if (null != resultSet && resultSet.length() > 0) {
                	org.json.JSONObject rs = (org.json.JSONObject) resultSet.get(0);
                	transID = rs.optString("TransId");
                }
            }
        } catch (Exception ex) {
            logger.error("Exception in saveDisabilityCertificateDetails : ", ex);
        }
		return transID;
	}
}
