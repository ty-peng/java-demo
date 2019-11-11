package com.typeng.demo.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ty-peng
 * @since 2019/1/23 17:34
 */
public class FileReaderWriterDemo {
    public static void main(String[] args) throws IOException {
        // 无法设置编码！
        FileReader fr = new FileReader("demo/text.txt");
        FileWriter fw = new FileWriter("demo/text2.txt", true);
        char[] buf = new char[8 * 1024];
        int c;
        while ((c = fr.read(buf, 0, buf.length)) != -1) {
            fw.write(buf, 0, c);
            fw.flush();
        }
        fr.close();
        fw.close();
    }
}
