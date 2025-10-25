package io.magicianlib.fs.exception;

/**
 * 序列化异常
 *
 * @author magicianlib@gmail.com
 * @since 2021/03/08 15:45
 */
public class SerializationException extends RuntimeException {

    private static final String MSG_FOR_SPECIFIED_CLASS = "Serialize for class [%s] failed. ";

    private Class<?> serializedClass;

    public SerializationException() {
        super();
    }

    public SerializationException(Throwable throwable) {
        super(throwable);
    }

    public SerializationException(Class<?> serializedClass) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, serializedClass.getName()));
        this.serializedClass = serializedClass;
    }

    public SerializationException(Class<?> serializedClass, Throwable throwable) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, serializedClass.getName()), throwable);
        this.serializedClass = serializedClass;
    }

    public Class<?> getSerializedClass() {
        return serializedClass;
    }
}