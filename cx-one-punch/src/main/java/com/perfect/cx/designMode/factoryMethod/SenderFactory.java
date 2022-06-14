package com.perfect.cx.designMode.factoryMethod;

import javax.validation.constraints.Email;

public class SenderFactory {
    public Sender product(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            return null;
        }
    }

    public static Sender mailProduct() {
        return new MailSender();
    }

    public static Sender smsProduce() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = SenderFactory.smsProduce();
        sender.sender();
        Sender sender1 = SenderFactory.mailProduct();
        sender1.sender();

    }
}
