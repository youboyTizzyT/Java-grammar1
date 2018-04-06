package day7.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 文件操作之创建
 * @author weicong
 * @date 2018/3/27 0027
 */
public class FileIo {
    public static void main(String[] args) {
        // 创建文件夹
        boolean result=mkdirFile(".\\team\\wt.javalearn\\java\\src\\main\\day7\\io\\a\\b\\c\\d\\e\\f\\g\\h\\i");
        boolean result1=mkdirFile(".\\team\\wt.javalearn\\java\\src\\main\\day7\\io\\a\\b\\c\\d\\e\\f\\g\\h");
        System.out.println(result);
        System.out.println(result1);
        // 删除目录
        deleteDir(new File("./team/wt.javalearn/java/src/main/day7/io/a/b/c/d"));
        // 检验文件是否为空
        changeFileIsNull("./team");
        // 查看是否为隐藏文件
        isHidden("./.idea");
        // 寻找目录下的文件
        findFile(new File("./team"));
        // 获取文件的父文件
        getParentFile("./team");
        // 获取文件最后修改时间
        getFileLastChange("./team");
        // 打印文件结构
        showDir(1, new File("./team"));
    }

    /**
     *  mkdirs就是创建文件,如果当前目录下没有我要寻找的文件,我就会创建,如果找到最后存在我的路径中,我就返回false
     * @param directories 传入的文件路径
     * @return boolean
     */
    static boolean mkdirFile(String directories){
        File file = new File(directories);
        return file.mkdirs();
    }

    /**
     *  删除文件夹  删除dir目录下所有文件
     * @param dir 创建目录
     * @return 返回是否成功
     */
    static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                System.out.println(children[i]);
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        if(dir.delete()) {
            System.out.println("目录已被删除！");
            return true;
        } else {
            System.out.println("目录删除失败！");
            return false;
        }
    }

    /**
     * 判断文件夹是否为空
     * @param dir
     */
    static void changeFileIsNull(String dir){
        File file = new File(dir);  // 当前目录下的 testdir目录
        if(file.isDirectory()){
            if(file.list().length>0){
                System.out.println("目录不为空!");
            }else{
                System.out.println("目录为空!");
            }
        }else{
            System.out.println("这不是一个目录!");
        }
    }

    /**
     * 判断文件是否为隐藏文件
     * @param dir
     */
    static void isHidden(String dir){
        File file = new File(dir);
        System.out.println(file.isHidden());
    }

    /**
     * 在指定目录中查找文件
     * @param file 文件
     */
    static void findFile(File file){
        String[] children = file.list();
        if (children == null) {
            System.out.println("该目录不存在");
        }
        else {
            for (int i = 0; i < children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }
    }

    /**
     * 获取文件的上级目录
     * @param dir 文件路径
     */
    static void getParentFile(String dir){
        File file = new File(dir);
        String strParentDirectory = file.getParent();
        System.out.println("文件的上级目录为 : " + strParentDirectory);
    }

    /**
     * 获取文件最后修改时间
     * @param dir 文件路径
     */
    static void getFileLastChange(String dir){
        File file = new File(dir);
        System.out.println("最后修改时间：" + new Date(file.lastModified()));
    }

    /**
     * 打印文件结构
     * @param indent 前置横线长度
     * @param file 文件
     */
    static void showDir(int indent, File file) {
        for (int i = 0; i < indent; i++)
            System.out.print('-');
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++)
                showDir(indent + 4, files[i]);
        }
    }
}
