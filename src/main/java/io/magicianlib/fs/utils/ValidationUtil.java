package io.magicianlib.fs.utils;

import io.magicianlib.fs.exception.BizArgumentException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationUtil {
    /**
     * Spring Boot 会自动注入配置好的 Validator 实例
     */
    private final Validator validator;

    @Autowired
    public ValidationUtil(Validator validator) {
        this.validator = validator;
    }

    /**
     * 对传入的 Object 进行校验
     * <p>
     * 如果校验失败，则抛出 ConstraintViolationException</p>
     *
     * @param obj    待校验的对象
     * @param groups 校验分组（可选）
     * @param <T>    对象的类型
     */
    public <T> void validate(T obj, Class<?>... groups) {
        // 调用 Validator 的 validate 方法
        Set<ConstraintViolation<T>> violations = validator.validate(obj, groups);

        if (!violations.isEmpty()) {
            // 使用 Bean Validation 规范定义的异常
            // throw new ConstraintViolationException(violations);

            for (ConstraintViolation<T> violation : violations) {
                throw new BizArgumentException("请求参数不合法[%s: %s]", violation.getPropertyPath(), violation.getMessage());
            }

            /*
            // 自定义异常，并格式化错误信息（更友好）
            String errorMsg = violations.stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .collect(Collectors.joining(", "));

            throw new IllegalArgumentException("校验失败: " + errorMsg);
            */
        }
    }
}