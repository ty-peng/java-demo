package com.typeng.demo.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author ty-peng
 * @since 2019/1/22 17:14
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
        File demo = new File("demo"); // 相对路径，项目目录下
        if (!demo.exists()) {
            demo.mkdir();
        }
        File file = new File(demo, "raf.dat");
        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        // 指针的位置
        System.out.println(raf.getFilePointer());

        // --------------写文件--------------

        // Java中 JVM 编码采用utf16 char占两个字节
        raf.write('A');
        // write() 每次只能写一个字节
        raf.write('B');
        int i = 0x7fffffff;


        raf.write(i >>> 24); // 高8位
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);

        raf.writeInt(i);
        System.out.println(raf.getFilePointer());
        String s = "中";
        byte[] gbk = s.getBytes("gbk");
        raf.write(gbk);


        // -------------读文件-------------
        // 读文件，必须把指针移到头部
        raf.seek(0);
        // 一次性读取，把文件中的内容都读到字节数组中
        byte[] buf = new byte[(int)raf.length()];
        raf.read(buf);
        //System.out.println(Arrays.toString(buf));
        //String res = new String(buf, "gbk");  // 此处编码无效，因为最开始写入的字节数组编码的字节数就不同
        //System.out.println(res);
        for (byte b : buf) {
            System.out.println(Integer.toHexString(b & 0xff));
        }
        // 记得关闭
        raf.close();
    }

}
