package com.perfect.cx.designMode.builder;

public class Test {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.mailSenderProduct(2);
        builder.smsSenderProduct(1);
        System.out.println(builder.senderList);
    }
}
