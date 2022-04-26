package com.perfect.cx.sourceSpring.proxy.service.impl;

import com.perfect.cx.sourceSpring.proxy.service.MyServiceInterface;

public class MyServiceImpl implements MyServiceInterface {
    @Override
    public void doService() {
        System.out.println("==========doService=========");
    }
}
