package com.typeng.demo.io;

import com.typeng.demo.io.util.IOUtil;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ty-peng
 * @since 2019/1/23 15:34
 */
public class DataOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        String file = "demo/dos.dat";
        // 包装模式（装饰者模式）
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        // 采用 utf-8 编码写出
        dos.writeUTF("中国");
        // 默认采用 Java 的 utf-16be 编码写出
        dos.writeChars("中国");
        dos.close();
        IOUtil.inPrintHex(file);
    }

}
