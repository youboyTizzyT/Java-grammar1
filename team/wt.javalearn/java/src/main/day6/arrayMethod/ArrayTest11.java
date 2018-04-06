package day6.arrayMethod;

import java.util.Arrays;

/**
 * 判断数组是否相等
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest11 {
    public static void main(String[] args) throws Exception {
        int[] ary = {1,2,3,4,5,6};
        int[] ary1 = {1,2,3,4,5,6};
        int[] ary2 = {1,2,3,4};
        System.out.println("数组 ary 是否与数组 ary1相等? ：" + Arrays.equals(ary, ary1));
        System.out.println("数组 ary 是否与数组 ary2相等? ：" +Arrays.equals(ary, ary2));
    }
}
