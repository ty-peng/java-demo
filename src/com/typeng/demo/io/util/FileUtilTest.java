package com.typeng.demo.io.util;

import com.typeng.demo.io.util.FileUtil;

import java.io.File;
import java.io.IOException;

/**
 * @author ty-peng
 * @since 2019/1/22 15:34
 */
public class FileUtilTest {

    public static void main(String[] args) throws IOException {
        FileUtil.listDirectory(new File("E:\\Me\\Desktop\\文档"));
        //FileUtil.walkTree();
    }
}
