package day7.io;

import java.io.File;
import java.util.Date;

/**
 * 修改文件最后的修改日期
 * @author weicong
 * @date 2018/3/27 0027
 */
public class FileLastChangeTime {
    public static void main(String[] args) throws Exception {
        File fileToChange = new File("./team/wt.javalearn/java/src/main/day7/io/ioFile");
        fileToChange.createNewFile();
        Date filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
        System.out.println(fileToChange.setLastModified(System.currentTimeMillis()));
        filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
    }
}
