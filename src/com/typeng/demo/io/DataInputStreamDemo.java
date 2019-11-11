package com.typeng.demo.io;

import com.typeng.demo.io.util.IOUtil;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ty-peng
 * @since 2019/1/23 15:46
 */
public class DataInputStreamDemo {

    public static void main(String[] args) throws IOException {
        String file = "demo/dos.dat";
        IOUtil.inPrintHex(file);
        // 包装模式（装饰者模式）
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        dis.readLong();
        dis.readDouble();
        String s = dis.readUTF();
        System.out.println(s);
        dis.close();
    }

}
