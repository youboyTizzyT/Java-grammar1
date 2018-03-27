package day7.io;

import java.io.File;

/**
 * 获取文件大小
 * @author weicong
 * @date 2018/3/27 0027
 */
public class FileHowBig {
    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }
    public static void main(String[] args) {
        long size = getFileSize("./team/wt.javalearn/java/src/main/day7/io/ioFile/google.txt");
        System.out.println("文件大小为: " + size);
    }
}
