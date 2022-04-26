package com.perfect.cx.sourceSpring.proxy.interceptor;

public class LogInterceptor implements Interceptor{
    @Override
    public void before() {
        System.out.println("在方法前打log");
    }

    @Override
    public void after() {
        System.out.println("在方法后打log");
    }
}
