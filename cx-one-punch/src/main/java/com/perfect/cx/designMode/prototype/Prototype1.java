package com.perfect.cx.designMode.prototype;


public class Prototype1 implements Cloneable{
    int a = 10;
    int b = 20;
    String string = "1111";

    public String getString() {
        return string;
    }

    public void setString(String str) {
        this.string = str;
    }

    public Object cloneTest() throws CloneNotSupportedException {
        Prototype1 clone = (Prototype1) super.clone();
        return clone;
    }

    public static void main(String[] args) {
        Prototype1 prototype1 = new Prototype1();
        System.out.println(prototype1);
        Prototype1 o = null;
        try {
            o = (Prototype1) prototype1.cloneTest();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(o);
        o.setString("222");
        System.out.println(prototype1);
        System.out.println(o);
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "a=" + a +
                ", b=" + b +
                ", string='" + string + '\'' +
                '}';
    }
}
