package com.perfect.cx.designMode.builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    public List<Sender> senderList = new ArrayList<>();

    public void mailSenderProduct(int count) {
        for (int i = 0; i <= count; i++){
            senderList.add(new MailSender());
        }
    }

    public void smsSenderProduct(int count) {
        for (int i = 0; i <= count; i++) {
            senderList.add(new SmsSender());
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.mailSenderProduct(1);
        builder.smsSenderProduct(1);
        System.out.println(builder.senderList);
    }
}
