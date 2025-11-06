package io.magicianlib.fs.aspect;

import io.magicianlib.fs.config.LoggingDirValidator;
import io.magicianlib.fs.constants.Log;
import io.magicianlib.fs.exception.BizArgumentException;
import io.magicianlib.fs.exception.BizException;
import io.magicianlib.fs.request.AbstractRequest;
import io.magicianlib.fs.result.Result;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.MDC;

import java.util.UUID;

public abstract class AbstractFacadeAspect {
    protected static final Logger LOGGER = LogManager.getLogger(LoggingDirValidator.class);

    public abstract void executeFacade(AbstractRequest request);

    @Around(value = "executeFacade(request)", argNames = "joinPoint,request")
    public Object aroundFacadeExecution(ProceedingJoinPoint joinPoint, AbstractRequest request) {
        try {
            preProceed(joinPoint, request);

            String traceId = request.getTraceId();
            if (StringUtils.isBlank(traceId)) {
                traceId = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
                request.setTraceId(traceId);
            }
            MDC.put(Log.TRANCE_ID, traceId);

            Result<?> result = (Result<?>) joinPoint.proceed(new Object[]{request});
            if (result != null) {
                if (StringUtils.isBlank(result.getTraceId())) {
                    result.setTraceId(traceId);
                }
                postProceed(joinPoint, request, result);
            }

            return result;
        } catch (BizArgumentException e) {
            LOGGER.error("请求参数异常：{}", e.getMessage(), e);
            throw e;
        } catch (BizException e) {
            LOGGER.error("业务处理异常：{}", e.getMessage(), e);
            throw e;
        } catch (Throwable e) {
            throw new BizException(e);
        }
    }

    protected void preProceed(ProceedingJoinPoint joinPoint, AbstractRequest request) {
    }

    protected void postProceed(ProceedingJoinPoint joinPoint, AbstractRequest request, Result<?> result) {
    }
}