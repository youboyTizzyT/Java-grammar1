package day6.arrayMethod;

import java.util.Arrays;

/**
 * 数组填充
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest6 {
    public static void main(String args[]) {
        int array[] = new int[6];
        Arrays.fill(array, 100);
        for (int i=0, n=array.length; i < n; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
        Arrays.fill(array, 3, 6, 50);
        for (int i=0, n=array.length; i< n; i++) {
            System.out.println(array[i]);
        }
    }
}
