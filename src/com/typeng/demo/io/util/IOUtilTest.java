package com.typeng.demo.io.util;

import java.io.File;
import java.io.IOException;

/**
 * @author ty-peng
 * @since 2019/1/23 09:50
 */
public class IOUtilTest {

    public static void main(String[] args) {
        try {
            IOUtil.inPrintHex("demo/raf.dat");
            System.out.println("\n------------------------------------");
            IOUtil.inPrintHexByByteArray("demo/raf.dat");
            System.out.println("\n------------------------------------");

            long start = System.currentTimeMillis();
            IOUtil.copyFileByByte(new File("demo/img.jpg"), new File("demo/copy.jpg"));
            long end = System.currentTimeMillis();
            System.out.println(end - start);

            start = System.currentTimeMillis();
            IOUtil.copyFile(new File("demo/img.jpg"), new File("demo/copy2.jpg"));
            end = System.currentTimeMillis();
            System.out.println(end - start);

            start = System.currentTimeMillis();
            IOUtil.copyFileByBuffer(new File("demo/img.jpg"), new File("demo/copy3.jpg"));
            end = System.currentTimeMillis();
            System.out.println(end - start);

            start = System.currentTimeMillis();
            IOUtil.copyFileByBufferByteArray(new File("demo/img.jpg"), new File("demo/copy4.jpg"));
            end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
