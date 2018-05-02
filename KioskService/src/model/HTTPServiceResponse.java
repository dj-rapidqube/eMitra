package model;

import java.util.List;
import java.util.Map;

public class HTTPServiceResponse {

    private int status;
    private String body;
    private byte[] bytes;
    private Map<String, List<String>> headerToValuesMap;

    public HTTPServiceResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Map<String, List<String>> getHeaderToValuesMap() {
        return headerToValuesMap;
    }

    public void setHeaderToValuesMap(Map<String, List<String>> headerToValuesMap) {
        this.headerToValuesMap = headerToValuesMap;
    }

    @Override
    public String toString() {
        return "ServiceResponse [" + "status=" + status + ", headerToValuesMap=" + headerToValuesMap + "]";
    }

}
