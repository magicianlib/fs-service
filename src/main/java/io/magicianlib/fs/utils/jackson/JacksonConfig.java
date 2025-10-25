package io.magicianlib.fs.utils.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.magicianlib.fs.utils.DateFormatUtil;

import java.time.*;

/**
 * Jackson Config
 *
 * @author magicianlib@gmail.com
 */
public final class JacksonConfig {

    /**
     * 配置 Java8 日期处理格式
     *
     * @param objectMapper 实例
     */
    public static void configureObjectMapper4Jsr310(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());

        // 禁用 JSR310 将日期时间写为时间戳的特性 默认行为，必须禁用才能使用后面的字符串格式
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // LocalTime 序列化和反序列化配置
        JsonFormat.Value localTimeFormat = JsonFormat.Value.forShape(JsonFormat.Shape.STRING).withPattern(DateFormatUtil.ISO_LOCAL_TIME_PATTERN);
        objectMapper.configOverride(LocalTime.class).setFormat(localTimeFormat);

        // LocalDate 序列化和反序列化配置
        JsonFormat.Value localDateFormat = JsonFormat.Value.forShape(JsonFormat.Shape.STRING).withPattern(DateFormatUtil.ISO_LOCAL_DATE_PATTERN);
        objectMapper.configOverride(LocalDate.class).setFormat(localDateFormat);

        // LocalDateTime 序列化和反序列化配置
        JsonFormat.Value localDateTimeFormat = JsonFormat.Value.forShape(JsonFormat.Shape.STRING).withPattern(DateFormatUtil.DATE_TIME_PATTERN);
        objectMapper.configOverride(LocalDateTime.class).setFormat(localDateTimeFormat);

        // OffsetDateTime 序列化和反序列化配置
        JsonFormat.Value offsetDateTimeFormat = JsonFormat.Value.forShape(JsonFormat.Shape.STRING).withPattern(DateFormatUtil.DATE_TIME_PATTERN);
        objectMapper.configOverride(OffsetDateTime.class).setFormat(offsetDateTimeFormat);

        // OffsetTime 序列化和反序列化配置
        JsonFormat.Value offsetTimeFormat = JsonFormat.Value.forShape(JsonFormat.Shape.STRING).withPattern(DateFormatUtil.ISO_LOCAL_TIME_PATTERN);
        objectMapper.configOverride(OffsetTime.class).setFormat(offsetTimeFormat);
    }

    /**
     * 序列化对 Null 值处理
     *
     * @param objectMapper 实例
     */
    public static void configureNullObject(ObjectMapper objectMapper) {

        SerializerFactory serializerFactory = objectMapper.getSerializerFactory()
                .withSerializerModifier(new JacksonBeanNullValueSerializerModifier());

        objectMapper.setSerializerFactory(serializerFactory);
    }

    /**
     * 添加自定义序列化实现
     *
     * @param objectMapper 实例
     */
    public static <T> void registerModule(ObjectMapper objectMapper, Class<? extends T> type, JsonSerializer<T> serializer) {

        SimpleModule module = new SimpleModule();
        module.addSerializer(type, serializer);

        objectMapper.registerModule(module);
    }

    /**
     * 添加自定义反序列化实现
     *
     * @param objectMapper 实例
     */
    public static <T> void registerModule(ObjectMapper objectMapper, Class<T> type, JsonDeserializer<? extends T> deserializer) {

        SimpleModule module = new SimpleModule();
        module.addDeserializer(type, deserializer);

        objectMapper.registerModule(module);
    }
}