package io.magicianlib.fs.request;

import io.magicianlib.fs.utils.PrintFriendliness;

public abstract class AbstractRequest extends PrintFriendliness {
    public AbstractRequest() {
    }

    private String appId;
    private String requestId;
    private boolean needLog = true;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isNeedLog() {
        return needLog;
    }

    public void setNeedLog(boolean needLog) {
        this.needLog = needLog;
    }
}