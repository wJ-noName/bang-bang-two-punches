package com.perfect.cx.sourceSpring.aop;

public class Service implements ServiceInterface{
    public Service() {
        System.out.println("==========Servie=========");
    }

    public int doService(int i) {
        int result = 5 / i;
        System.out.println("运行doService");
        return result;
    }
}
