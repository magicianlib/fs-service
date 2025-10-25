package io.magicianlib.fs.exception;

/**
 * 参数类业务异常
 *
 * @author magicianlib@gmail.com
 */
public class BizArgumentException extends BizException {
    public BizArgumentException() {
        super();
    }

    public BizArgumentException(String format, Object... args) {
        super(String.format(format, args));
    }

    public BizArgumentException(Throwable cause) {
        super(cause);
    }

    public BizArgumentException(Throwable cause, String format, Object... args) {
        super(String.format(format, args), cause);
    }
}