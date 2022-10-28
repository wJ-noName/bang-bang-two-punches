package com.perfect.cx.designMode.proxy;

public class Proxy implements Sourceable{
    private Source source;

    public Proxy() {
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        end();
    }

    private void end() {
        System.out.println("oh~~this is end");
    }

    private void before() {
        System.out.println("oh~~this is before");
    }
}
