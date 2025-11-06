package io.magicianlib.fs.request;

import io.magicianlib.fs.utils.PrintFriendliness;

public abstract class AbstractRequest extends PrintFriendliness {
    public AbstractRequest() {
    }

    private String appId;
    private String traceId;
    private boolean needLog = true;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public boolean isNeedLog() {
        return needLog;
    }

    public void setNeedLog(boolean needLog) {
        this.needLog = needLog;
    }
}