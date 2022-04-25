package com.perfect.cx.sourceSpring;

import com.perfect.cx.sourceSpring.service.MyServiceInterface;
import com.perfect.cx.sourceSpring.service.impl.MyServiceImpl;



public class Test {
    public static void main(String[] args) {
        AopProxy1 aopProxy1 = new AopProxy1();
        MyServiceInterface myService = new MyServiceImpl();

        aopProxy1.setMyServiceInterface(myService);
        aopProxy1.doService();
    }
}
