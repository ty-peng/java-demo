package com.typeng.demo.io.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author ty-peng
 * @since 2019/1/22 15:27
 */
public class FileUtil {

    /**
     * 列举指定目录下（包括其子目录）的所有文件
     *
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + "不存在！");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录！");
        }
        // dir.list(); // 列出当前目录下的子目录和文件名称，返回字符串数组
        File[] files = dir.listFiles(); // 返回直接子目录（文件）的抽象
        if (files != null && files.length > 0) {
            for (File file : files) {
                System.out.println(file);
                // 子文件夹递归
                if (file.isDirectory()) {
                    listDirectory(file);
                }
            }
        }

    }

    /**
     * 遍历指定目录下（包括其子目录）.
     * Java8 使用流式编程和 lambda 表达式
     *
     * @throws IOException
     */
    public static void walkTree() throws IOException {
        Path start = FileSystems.getDefault().getPath("E:\\Me\\Desktop\\文档");
        Files.walk(start)
                //.filter(path -> path.toFile().isFile())
                .forEach(System.out::println);
    }
}
