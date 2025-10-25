package io.magicianlib.fs.aspect;

import io.magicianlib.fs.exception.BizException;
import io.magicianlib.fs.request.AbstractRequest;
import io.magicianlib.fs.utils.ValidationUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class FacadeParameterAspect extends AbstractFacadeAspect {
    private final ValidationUtil validationUtil;

    @Autowired
    public FacadeParameterAspect(ValidationUtil validationUtil) {
        this.validationUtil = validationUtil;
    }

    @Override
    @Pointcut("execution(* io.magicianlib.fs.facade..*Facade.*(*)) && args(request)")
    public void executeFacade(AbstractRequest request) {
    }

    @Override
    protected void preProceed(ProceedingJoinPoint joinPoint, AbstractRequest request) {
        BizException.requireNonnull(request, "request parameter is null");
        validationUtil.validate(request);
    }
}