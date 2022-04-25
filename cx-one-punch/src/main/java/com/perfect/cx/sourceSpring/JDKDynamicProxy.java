package com.perfect.cx.sourceSpring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {
    Object target;

    public Object getProxy(Object target) {
        this.target = target;
        Class<?> aClass = target.getClass();
        ClassLoader classLoader = aClass.getClassLoader();
        Class<?>[] interfaces = aClass.getInterfaces();
        Object object = Proxy.newProxyInstance(classLoader, interfaces, this);
        return object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("======JDKDynamicProxy 调用之前=======");
        method.invoke(this.target, args);
        System.out.println("======JDKDynamicProxy 调用之后=======");
        return null;
    }
}
