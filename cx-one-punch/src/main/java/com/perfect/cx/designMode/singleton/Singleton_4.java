package com.perfect.cx.designMode.singleton;

public class Singleton_4 {
    private static Singleton_4 instance = null;
    private Singleton_4(){}

    public static Singleton_4 getInstance() {
        if (instance == null) {
            init();
        }
        return instance;
    }

    private static synchronized void init(){
        if (instance == null) {
            instance = new Singleton_4();
        }
    }
}
