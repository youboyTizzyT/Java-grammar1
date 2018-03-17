package day1;

/**
 * 强制类型转换
 * @author weicong
 * @date 2018/3/17 0017
 */
public class QiangZhiZhuanHuan {
    public static void main(String[] args){
        /*
         * 1. 条件是转换的数据类型必须是兼容的。
         * 2. 格式：(type)value type是要强制类型转换后的数据类型
         */
        int i1 = 123;
        byte b = (byte)i1;//强制类型转换为byte
        System.out.println("int强制类型转换为byte后的值等于"+b);
    }
}
