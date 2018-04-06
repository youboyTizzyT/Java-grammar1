package day6.arrayMethod;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest4 {
    public static void main(String[] args) {
        Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5};
        int min = Collections.min(Arrays.asList(numbers));
        int max = Collections.max(Arrays.asList(numbers));
        System.out.println("最小值: " + min);
        System.out.println("最大值: " + max);
    }
}
