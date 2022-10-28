package com.perfect.cx.designMode.decrator;

public class Decorator implements Sourceable{
    private Source source;

    public Decorator(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method(){
        System.out.println("this is power");
        source.method();
        System.out.println("this is end");
    }

    public static void main(String[] args) {
        Decorator decorator = new Decorator(new Source());
        decorator.method();
    }
}
