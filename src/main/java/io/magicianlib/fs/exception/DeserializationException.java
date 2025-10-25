package io.magicianlib.fs.exception;

import java.lang.reflect.Type;

/**
 * 反序列化异常
 *
 * @author magicianlib@gmail.com
 */
public class DeserializationException extends RuntimeException {

    private static final String MSG_FOR_SPECIFIED_CLASS = "deserialize for class [%s] failed. ";

    private Class<?> targetClass;

    public DeserializationException() {
        super();
    }

    public DeserializationException(Throwable throwable) {
        super(throwable);
    }

    public DeserializationException(Type targetType) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, targetType.toString()));
    }

    public DeserializationException(Type targetType, Throwable throwable) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, targetType.toString()), throwable);
    }

    public DeserializationException(Class<?> targetClass) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, targetClass.getName()));
        this.targetClass = targetClass;
    }

    public DeserializationException(Class<?> targetClass, Throwable throwable) {
        super(String.format(MSG_FOR_SPECIFIED_CLASS, targetClass.getName()), throwable);
        this.targetClass = targetClass;
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }
}