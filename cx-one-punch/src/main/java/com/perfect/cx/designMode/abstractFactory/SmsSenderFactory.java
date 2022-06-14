package com.perfect.cx.designMode.abstractFactory;

public class SmsSenderFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
