package com.perfect.cx.designMode.singleton;

public class Test {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton_2 instance = Singleton_2.getInstance();
                    System.out.println(instance);
                }
            }).start();

        }
        System.out.println(System.currentTimeMillis() - l + "ms");
    }
}
