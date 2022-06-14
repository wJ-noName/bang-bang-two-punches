package com.perfect.cx.designMode.prototype;

import java.io.*;

public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String string = "333";

    private SerializableObject obj;

    public String getString() {
        return string;
    }

    public void setString(String str) {
        this.string = str;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    /*
             浅复制
             */
    public Object clone_a() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
        return proto;
    }

    /*
     深复制
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        //写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Prototype prototype = new Prototype();
        Object o = prototype.deepClone();
        System.out.println(o);
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "string='" + string + '\'' +
                ", obj=" + obj +
                '}';
    }
}
