package com.perfect.cx.designMode.factoryMethod;

public class MailSender implements Sender{
    @Override
    public void sender() {
        System.out.println("this is MailSender");
    }
}
