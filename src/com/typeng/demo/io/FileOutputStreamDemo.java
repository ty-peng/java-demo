package com.typeng.demo.io;

import com.typeng.demo.io.util.IOUtil;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ty-peng
 * @since 2019/1/23 15:28
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        // 如果该文件不存在，则直接创建，如果存在，删除后创建
        //FileOutputStream out = new FileOutputStream("demo/out.dat");

        // append为true，如果该文件不存在，则直接创建，如果存在，内容后面追加
        FileOutputStream out = new FileOutputStream("demo/out.dat", true);

        // write() 一次只能写8位一个字节
        out.write('A');  // 写出'A'的低八位
        int a = 10;
        // int 4个字节 写四次
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);

        byte[] gbk = "中国".getBytes("gbk");
        out.write(gbk);
        out.close();

        IOUtil.inPrintHex("demo/out.dat");
    }
}
