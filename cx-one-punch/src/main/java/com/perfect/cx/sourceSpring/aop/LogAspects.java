package com.perfect.cx.sourceSpring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspects {

    public LogAspects() {
        System.out.println("========LogAspects========");
    }

    @Pointcut("execution(* com.perfect.cx.sourceSpring.aop.Service.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("logStart 开始运行:" + joinPoint.getSignature().getName());
    }

    @After("pointCut()")
    public void logAfter() {
        System.out.println("logAfter 结束运行");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturning(Object result) {
        System.out.println("logReturning 正常返回，结果：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("logStarException 运行异常:" + exception);
    }
}
