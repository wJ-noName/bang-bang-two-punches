package com.perfect.cx.designMode.abstractFactory;

public class MailSender implements Sender{
    @Override
    public void sender() {
        System.out.println("this is MailSender");
    }
}
