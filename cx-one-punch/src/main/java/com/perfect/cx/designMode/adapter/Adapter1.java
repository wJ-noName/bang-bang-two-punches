package com.perfect.cx.designMode.adapter;

public class Adapter1 implements Targetable{
    private Source source;

    public Adapter1(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void test1() {
        source.test1();
    }

    @Override
    public void test2() {
        System.out.println("this is targetable");
    }

    public static void main(String[] args) {
        Source source = new Source();
        Adapter1 adapter1 = new Adapter1(source);
        adapter1.test1();
        adapter1.test2();
    }
}
