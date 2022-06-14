package com.perfect.cx.designMode.abstractFactory;

import com.perfect.cx.designMode.builder.Builder;

public class Test {
    public static void main(String[] args) {
        Provider provider = new MailSenderFactory();
        provider.produce().sender();
        Provider provider2 = new SmsSenderFactory();
        provider2.produce().sender();
    }
}
