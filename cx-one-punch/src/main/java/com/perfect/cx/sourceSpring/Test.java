package com.perfect.cx.sourceSpring;

import com.perfect.cx.sourceSpring.interceptor.Interceptor;
import com.perfect.cx.sourceSpring.interceptor.LogInterceptor;
import com.perfect.cx.sourceSpring.interceptor.TimeInterceptor;
import com.perfect.cx.sourceSpring.service.MyServiceInterface;
import com.perfect.cx.sourceSpring.service.impl.MyServiceImpl;
import com.perfect.cx.sourceSpring.service.impl.OtherServiceImpl;


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
