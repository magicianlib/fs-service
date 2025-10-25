package io.magicianlib.fs.utils;

import io.magicianlib.fs.utils.jackson.JacksonUtils;

import java.io.Serial;
import java.io.Serializable;

public class PrintFriendliness implements Serializable {
    @Serial
    private static final long serialVersionUID = -1076993059939433848L;

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + JacksonUtils.toJson(this);
    }
}