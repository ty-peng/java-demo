package com.typeng.demo.io;

import java.io.File;
import java.io.IOException;

/**
 * @author ty-peng
 * @since 2019/1/22 14:52
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File("E:\\Me\\Desktop\\Workspace\\java-demo\\src\\file");  // 路径分隔符用 \\ 或者 / 皆可
        // 文件或目录是否存在
        if (!file.exists()) {
            // 创建目录
            file.mkdir();
            // 创建多级目录
            // file.mkdirs();
        } else {
            // 删除目录
            file.delete();
        }
        // 是否是目录
        file.isDirectory();
        // 是否是文件
        file.isFile();

        // File file2 = new File("E:\\Me\\Desktop\\Workspace\\java-demo\\src\\file.txt");
        File file2 = new File("E:\\Me\\Desktop\\Workspace\\java-demo\\src", "file.txt");
        if (!file2.exists()) {
            // 创建文件
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file2.delete();
        }

        // ----------------------常用API-------------------
        System.out.println(file);  // file.toString()的内容，路径
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.getParentFile().getAbsolutePath());

    }
}
