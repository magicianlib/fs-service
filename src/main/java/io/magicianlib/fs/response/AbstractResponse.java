package io.magicianlib.fs.response;

import io.magicianlib.fs.utils.PrintFriendliness;

public abstract class AbstractResponse extends PrintFriendliness {
    private boolean needLog = true;

    public boolean isNeedLog() {
        return needLog;
    }

    public void setNeedLog(boolean needLog) {
        this.needLog = needLog;
    }
}