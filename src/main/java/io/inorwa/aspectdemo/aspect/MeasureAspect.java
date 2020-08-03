package io.inorwa.aspectdemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class MeasureAspect {
    
    @Around("@annotation(MeasureTime)")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("start measureTime on method {}", joinPoint.getSignature().getName());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        stopWatch.stop();
        log.info("end measureTime, it takes:{}",stopWatch.getTotalTimeMillis());
        return result;
    }
}
