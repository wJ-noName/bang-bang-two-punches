package com.perfect.cx;

public class Test {
    public static void main(String[] args) {
        String s = (new StringBuilder("sapjco3".length() + 6)).append("lib").append("sapjco3").append(".so").toString();
        System.out.println(s);
    }
}
