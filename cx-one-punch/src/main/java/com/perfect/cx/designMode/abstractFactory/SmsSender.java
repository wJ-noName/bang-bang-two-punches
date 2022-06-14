package com.perfect.cx.designMode.abstractFactory;

public class SmsSender implements Sender{
    @Override
    public void sender() {
        System.out.println("this is SmsSender");
    }
}
