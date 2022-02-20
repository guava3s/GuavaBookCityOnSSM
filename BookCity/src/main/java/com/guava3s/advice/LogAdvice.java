package com.guava3s.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author micolen
 * @version 1.0
 * @ Aspect 标识切面类
 * @ClassName LogAdvice
 * @date 2022/1/4 16:32
 */
@Aspect
@Component
public class LogAdvice {

    private Logger log = Logger.getLogger(getClass());

    /**
     * 前置通知输出参数信息
     *
     * @param joinPoint
     */
    @Order(1)
    @Before(value = "execution(* com.guava3s.web.*.*.*(..))")
    public void logBeforeAdvice(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        String methodName = signature.toShortString();
        for (int i = 0; i < args.length; i++) {
            String temp = " 第[" + i + "]个参数为： ";
            log.debug(methodName + temp + args[i]);
        }
    }


    @Before(value = "execution(* com.guava3s.web.service.CarServiceImpl.listCarItemByLimit(..))")
    public void detectionIndex() {

    }

    /**
     * 对com.guava3s.service.impl.CarServiceImpl.listCarItemByLimit方法进行索引处理
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* com.guava3s.web.service.CarServiceImpl.listCarItemByLimit(..))")
    public Object aroundListCarItemByLimit(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        args[1] = String.valueOf(detectionIndex((String) args[1]));
        for (int i = 0; i < args.length; i++) {
            String temp = "args" + i;
            log.debug(temp + "={}" + args[i]);
        }
        return pjp.proceed(args);
    }

    /**
     * 索引检查
     *
     * @param index
     * @return
     */
    private Integer detectionIndex(String index) {
        Integer newIndex;
        try {
            if ((newIndex = Integer.parseInt(index)) <= 0) {
                newIndex = 1;
            }
        } catch (IllegalArgumentException e) {
            newIndex = 1;
        }
        return newIndex;
    }


}
