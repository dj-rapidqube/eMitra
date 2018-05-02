package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.stereotype.Component;

import model.HTTPServiceResponse;

@Component
public class HttpClientUtils {

    private static CloseableHttpClient httpClient;
    private static final int SOCKET_TIMEOUT = 60 * 60 * 1000;// 30 mins
    private static final int CONNECTION_TIMEOUT = 10 * 1000;// 10 secs

    @PostConstruct
    public void init() throws Exception {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(600);
        connectionManager.setDefaultMaxPerRoute(500);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT)
                .setConnectTimeout(CONNECTION_TIMEOUT).build();

        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager).build();
    }

    public HTTPServiceResponse getServiceResponse(HttpRequestBase method) throws Exception {
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(method);
            HTTPServiceResponse serviceResponse = new HTTPServiceResponse();
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            byte[] bytes = null;
            String body = null;
            if (entity != null) {
                bytes = IOUtils.toByteArray(entity.getContent());
                body = new String(bytes);
            }

            Map<String, List<String>> headerToValueMap = new HashMap<String, List<String>>();
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                String headerName = header.getName();
                String headerValue = header.getValue();
                if (headerToValueMap.get(headerName) == null) {
                    headerToValueMap.put(headerName, new ArrayList<String>());
                }

                headerToValueMap.get(headerName).add(headerValue);
            }

            serviceResponse.setStatus(status);
            serviceResponse.setBody(body);
            serviceResponse.setBytes(bytes);
            serviceResponse.setHeaderToValuesMap(headerToValueMap);
            return serviceResponse;
        } finally {
            if (response != null) {
                response.close();
            }

            if (method != null) {
                method.releaseConnection();
            }
        }
    }
}
