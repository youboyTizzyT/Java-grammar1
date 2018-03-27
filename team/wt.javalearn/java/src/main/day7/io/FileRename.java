package day7.io;

import java.io.File;

/**
 * 文件重命名
 * @author weicong
 * @date 2018/3/27 0027
 */
public class FileRename {
    public static void main(String[] args) {
        File oldName = new File("./team/wt.javalearn/java/src/main/day7/io/ioFile/rename.txt");
        File newName = new File("./team/wt.javalearn/java/src/main/day7/io/ioFile/rename1.txt");
        if(oldName.renameTo(newName)) {
            System.out.println("已重命名");
        } else {
            System.out.println("Error");
        }
    }
}
