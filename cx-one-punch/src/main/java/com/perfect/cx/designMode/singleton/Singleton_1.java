package com.perfect.cx.designMode.singleton;

public class Singleton_1 {
    private static Singleton_1 instance = null;

    private Singleton_1(){

    }

    public static synchronized Singleton_1 getInstance() {
        if (instance == null) {
            instance = new Singleton_1();
        }
        return instance;
    }
}
