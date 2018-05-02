package model;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONArray;

public class DBServiceResponse {

    private int status;
    private String body;
    private byte[] bytes;
    private JSONArray jsonArray;

    public DBServiceResponse() {
        // NO-OP
    }

    public DBServiceResponse(CloseableHttpResponse response) throws Exception {
        this.status = response.getStatusLine().getStatusCode();
        this.bytes = IOUtils.toByteArray(response.getEntity().getContent());
        this.body = IOUtils.toString(this.bytes);
        this.jsonArray = new JSONArray(this.body);
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    @Override
    public String toString() {
        return "DBServiceResponse [" + "status=" + status + ", jsonArray=" + jsonArray + "]";
    }
}
