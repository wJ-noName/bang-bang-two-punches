package com.perfect.cx.sourceSpring.proxy;

import com.perfect.cx.sourceSpring.proxy.interceptor.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxyAdvanced implements InvocationHandler {

    Object target;

    Interceptor interceptor;

    public void setInterceptor(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    public Object getProxy(Object target, Interceptor interceptor) {
        this.interceptor = interceptor;
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor.before();
        method.invoke(this.target, args);
        interceptor.after();
        return null;
    }
}
