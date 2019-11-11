package com.typeng.demo.io.serialization;

import java.io.*;

/**
 * @author ty-peng
 * @since 2019/1/23 18:36
 */
public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        String file = "demo/obj.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student stu = new Student("1001", "张三", 18);
        oos.writeObject(stu);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student stu2 = (Student)ois.readObject();
        System.out.println(stu2);
        ois.close();
    }
}
