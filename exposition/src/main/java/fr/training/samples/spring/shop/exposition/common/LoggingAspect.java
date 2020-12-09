package fr.training.samples.spring.shop.exposition.common;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(public * fr.training.samples.spring.shop.application..*.*(..))")
    private void monPointCut() {}

    @Before("monPointCut()")
    public void log(final JoinPoint jp){
        logger.info("==> " + jp.getSignature().toLongString());
        final Object[] args = jp.getArgs();
        StringBuilder sb=new StringBuilder();
        for( Object object : args){
         sb.append(object).append(",");
        }
        logger.info("==> argument de la methode : " + sb.toString());
    }
    @Around("monPointCut()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable{
        long start = System.currentTimeMillis();
        final Object obj =pjp.proceed();
        long end = System.currentTimeMillis();
        logger.info("==> Elpase time " + (end- start));
        return obj;
    }
}

