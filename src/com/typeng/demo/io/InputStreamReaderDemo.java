package com.typeng.demo.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ty-peng
 * @since 2019/1/23 16:52
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream("demo/text.txt");
        // 默认使用的是项目的编码
        InputStreamReader isr = new InputStreamReader(in, "utf-8");
        /*int c;
        while ((c = isr.read()) != -1) {
            System.out.print((char)c);
        }*/

        // 使用字符数组批量读取
        char[] buf = new char[8 * 1024];
        int b;
        // 最大读取 buf.length 个字符，返回读取到的字符数
        while ((b = isr.read(buf, 0, buf.length)) != -1) {
            String s = new String(buf, 0, b);
            System.out.println(s);
        }
        isr.close();
        in.close();
    }
}
