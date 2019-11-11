package com.typeng.demo.io.util;

import java.io.*;

/**
 * @author ty-peng
 * @since 2019/1/22 11:24
 */
public class IOUtil {

    /**
     * 单字节读取指定文件内容，按照16进制输出到控制台
     * 并且每输入10个byte换行
     *
     * @param fileName
     * @throws IOException
     */
    public static void inPrintHex(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;
        while ((b = in.read()) != -1) {
            if (b <= 0xf) { // 单位数补0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 使用字节数组读取指定文件内容，按照16进制输出到控制台
     * 并且每输入10个byte换行
     *
     * @param fileName
     * @throws IOException
     */
    public static void inPrintHexByByteArray(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[8 * 1024];
        /* 从in中批量读取字节，放入buf字节数组中,
          从第0个位置开始放，最多放buf.length个,
          返回读到的字节数
         */
        int bytes = 0;
        int j = 1;
        // 如果文件比buf字节数组大，一般采用这种形式
        while ((bytes = in.read(buf, 0, buf.length)) != -1) {
            for (int i = 0; i < bytes; i++) {
                // byte类型8位,int32位,通过 &0xff将高24位清零
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
                if (j++ % 10 == 0) {
                    System.out.println();
                }
            }
        }
        /*int bytes = in.read(buf, 0, buf.length);
        int j = 1;
        for (int i = 0; i < bytes; i++) {
            if (buf[i] <= 0xf && buf[i] >= 0x0) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
            if (j++ % 10 == 0) {
                System.out.println();
            }
        }*/
    }

    private static void checkFile(File srcFile) {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文化：" + srcFile + " 不存在！");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件！");
        }
    }

    /**
     * 使用字节数组复制文件，不使用缓冲
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        checkFile(srcFile);
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush(); // 最好加上
        }
        in.close();
        out.close();

    }

    /**
     * 使用单字节复制文件，不使用缓冲
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile, File destFile) throws IOException {
        checkFile(srcFile);
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
            out.flush(); // 最好加上
        }
        in.close();
        out.close();

    }

    /**
     * 利用带缓冲的字节流单字节进行文件拷贝
     *
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile, File destFile) throws IOException {
        checkFile(srcFile);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
            bos.flush(); // 刷新缓冲区才能写入文件
        }
        bis.close();
        bos.close();
    }


    public static void copyFileByBufferByteArray(File srcFile, File destFile) throws IOException{
        checkFile(srcFile);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = bis.read(buf, 0, buf.length)) != -1) {
            bos.write(buf, 0, b);
            bos.flush(); // 刷新缓冲区才能写入文件
        }
        bis.close();
        bos.close();

    }
}

