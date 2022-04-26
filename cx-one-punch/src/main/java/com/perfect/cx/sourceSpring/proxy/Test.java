package com.perfect.cx.sourceSpring.proxy;

import com.perfect.cx.sourceSpring.proxy.interceptor.Interceptor;
import com.perfect.cx.sourceSpring.proxy.interceptor.LogInterceptor;
import com.perfect.cx.sourceSpring.proxy.interceptor.TimeInterceptor;
import com.perfect.cx.sourceSpring.proxy.service.MyServiceInterface;
import com.perfect.cx.sourceSpring.proxy.service.impl.OtherServiceImpl;


public class Test {
    public static void main(String[] args) {
        MyServiceInterface serviceInterface = new OtherServiceImpl();
        JDKDynamicProxyAdvanced jdkDynamicProxyAdvanced = new JDKDynamicProxyAdvanced();
        Interceptor logInterceptor = new LogInterceptor();
        MyServiceInterface proxy = (MyServiceInterface) jdkDynamicProxyAdvanced.getProxy(serviceInterface, logInterceptor);
        proxy.doService();

        Interceptor timeInterceptor = new TimeInterceptor();
        jdkDynamicProxyAdvanced.setInterceptor(timeInterceptor);
        proxy.doService();
    }
}
