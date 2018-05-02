package model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class QueryDetails implements Serializable {

    private String procName;
    private Map<Integer, Object> queryParams;

    private boolean autoCommit = true;

    private static final long serialVersionUID = 2747976149414231326L;

    public QueryDetails() {
        queryParams = new LinkedHashMap<Integer, Object>();
    }

    public QueryDetails(String procName) {
        this();

        this.procName = procName;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public Map<Integer, Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<Integer, Object> queryParams) {
        this.queryParams = queryParams;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public QueryDetails addQueryParams(Integer key, Object value) {
        this.queryParams.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "QueryDetails [procName=" + procName + ", queryParams=" + queryParams + ", autoCommit=" + autoCommit + "]";
    }
}
