package com.perfect.cx.designMode.singleton;

public class Singleton_3 {
    private Singleton_3(){}


    public static Singleton_3 getInstance() {
        return SingletonFactory.instance;
    }

    private static class SingletonFactory{
        private static Singleton_3 instance = new Singleton_3();
    }
}
