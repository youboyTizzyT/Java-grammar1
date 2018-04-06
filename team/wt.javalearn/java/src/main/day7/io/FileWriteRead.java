package day7.io;

import java.io.*;

/**
 * 文件的写入与读取
 * @author weicong
 * @date 2018/3/27 0027
 */
public class FileWriteRead {
    public static void main(String[] args) throws IOException {
        fileWrite("./team/wt.javalearn/java/src/main/day7/io/ioFile/google.txt");
        fileRead("./team/wt.javalearn/java/src/main/day7/io/ioFile/google.txt");
        fileWrite1("./team/wt.javalearn/java/src/main/day7/io/ioFile/google.txt","\nlalala");
        /*
         * FileWriter 构造器的第二个参数,true和false代表是否同意追加.
         */
    }

    /**
     * 文件写入 覆盖
     * @param dir 写入的文件目录
     */
    static void fileWrite(String dir){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dir));
            out.write(String.valueOf(System.currentTimeMillis()));
            out.close();
        }catch (IOException e){
            System.err.println(e);
        }
        System.out.println("文件创建成功！"+System.currentTimeMillis());
    }

    /**
     * 文件写入 追加
     * @param dir 写入的文件目录
     */
    static void fileWrite1(String dir,String content){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(dir,true));
            out.write(content);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured"+ e);
        }
    }
    /**
     * 文件读取
     * @param dir 读取的文件目录
     */
    static void fileRead(String dir){
        try {
            BufferedReader in = new BufferedReader(new FileReader(dir));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
//            System.out.println(str);
        } catch (IOException e) {
        }
    }
}
