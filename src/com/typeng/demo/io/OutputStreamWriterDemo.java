package com.typeng.demo.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author ty-peng
 * @since 2019/1/23 17:13
 */
public class OutputStreamWriterDemo {

    public static void main(String[] args) throws IOException {
        FileOutputStream out = new FileOutputStream("demo/text.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
        // 使用字符数组批量写入
        char[] buf = "Hello\n".toCharArray();
        osw.write(buf, 0, buf.length);
        osw.flush();

        osw.close();
        out.close();
    }
}
