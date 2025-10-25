package io.magicianlib.fs.exception;

import java.util.Collection;
import java.util.Objects;

/**
 * 业务异常
 *
 * @author magicianlib@gmail.com
 */
public class BizException extends RuntimeException {
    public BizException() {
        super();
    }

    public BizException(String format, Object... args) {
        super(String.format(format, args));
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(Throwable cause, String format, Object... args) {
        super(String.format(format, args), cause);
    }

    public static void checkedCondition(boolean condition, String format, Object... args) {
        if (condition) {
            throw new BizException(format, args);
        }
    }

    public static void requireNonnull(Object obj, String format, Object... args) {
        if (Objects.isNull(obj)) {
            throw new BizException(format, args);
        }
    }

    public static <T> void requireNonEmpty(Collection<T> collection, String format, Object... args) {
        if (Objects.isNull(collection) || collection.isEmpty()) {
            throw new BizException(format, args);
        }
    }
}