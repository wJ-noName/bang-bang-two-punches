package com.perfect.cx.sourceSpring;

import com.perfect.cx.sourceSpring.service.MyServiceInterface;

public class AopProxy1 {
    private MyServiceInterface myService;

    public void setMyServiceInterface(MyServiceInterface myService) {
        this.myService = myService;
    }

    public void doService(){
        System.out.println("========doService之前========");
        myService.doService();
        System.out.println("========doService之后========");
    }
}
