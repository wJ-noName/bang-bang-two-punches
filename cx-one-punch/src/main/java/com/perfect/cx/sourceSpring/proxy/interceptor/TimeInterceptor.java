package com.perfect.cx.sourceSpring.proxy.interceptor;

public class TimeInterceptor implements Interceptor{
    @Override
    public void before() {
        System.out.println("我在方法前记录时间");
    }

    @Override
    public void after() {
        System.out.println("我在方法后记录时间");
    }
}
