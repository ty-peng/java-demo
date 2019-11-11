package com.typeng.demo.io;

import java.io.*;

/**
 * @author ty-peng
 * @since 2019/1/23 17:51
 */
public class BufferedReaderWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("demo/text.txt"), "utf-8"));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("demo/text2.txt", true), "utf-8"));
        // 相对更方便
        PrintWriter pw = new PrintWriter("demo/text3.txt");
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line); // 一次读一行，不识别文本文件里的换行
            bw.write(line);
            // 换行
            bw.newLine();
            bw.flush();

            pw.println(line);
            pw.flush(); // 可通过构造函数开启自动刷新
        }
        br.close();
        bw.close();
        pw.close();
    }
}
