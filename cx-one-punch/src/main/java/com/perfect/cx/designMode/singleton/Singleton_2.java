package com.perfect.cx.designMode.singleton;

public class Singleton_2 {
    private static Singleton_2 instance = null;

    private Singleton_2(){

    }

    public static Singleton_2 getInstance() {
        if (instance == null){
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton_2();
                }
            }
        }
        return instance;
    }
}
