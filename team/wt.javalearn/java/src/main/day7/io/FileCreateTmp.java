package day7.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * 创建临时文件
 *
 * @author weicong
 * @date 2018/3/27 0027
 */
public class FileCreateTmp {
    public static void main(String[] args) throws Exception {
        // 也可以使用 createTempFile(String prefix, String suffix, File directory) 中的 directory 参数来指定临时文件的
//        File temp = File.createTempFile("testrunoobtmp", ".txt");
//        System.out.println("文件路径: " + temp.getAbsolutePath());
//        temp.deleteOnExit();
//        BufferedWriter out = new BufferedWriter(new FileWriter(temp));
//        out.write("aString");
//        System.out.println("临时文件已创建:");
//        out.close();


        File f = null;
        // 创建临时文件
        f = File.createTempFile("tmp", ".txt", new File("./team/wt.javalearn/java/src/main/day7/io/ioFile"));
        // 输出绝对路径
        System.out.println("File path: " + f.getAbsolutePath());
        // 终止后删除临时文件
        f.deleteOnExit();
        // 创建临时文件
        f = File.createTempFile("tmp", null, new File("./team/wt.javalearn/java/src/main/day7/io/ioFile"));
        // 输出绝对路径
        System.out.print("File path: " + f.getAbsolutePath());
        // 终止后删除临时文件 可以根据业务需求是否删除
        f.deleteOnExit();
    }
}
