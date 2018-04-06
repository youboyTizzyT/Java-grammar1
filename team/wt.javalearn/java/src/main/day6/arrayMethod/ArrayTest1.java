package day6.arrayMethod;

import java.util.Arrays;

/**
 * 数组排序及元素查找
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        Arrays.sort(array);
        ArrayUtils.printArray("数组排序结果为", array);
        // binarySearch函数查找k在的位置
        int index = Arrays.binarySearch(array, 2);
        System.out.println("元素 2  在第 " + index + " 个位置");
    }
}
