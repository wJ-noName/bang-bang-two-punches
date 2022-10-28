package com.perfect.cx.designMode.adapter;

public class Adapter extends Source implements Targetable{
    public static void main(String[] args) {
        Targetable adapter = new Adapter();
        adapter.test1();
        adapter.test2();
    }

    @Override
    public void test2() {
        System.out.println("this is target method");
    }
}
