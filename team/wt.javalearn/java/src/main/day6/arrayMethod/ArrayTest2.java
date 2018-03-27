package day6.arrayMethod;

import java.util.Arrays;

import static day6.arrayMethod.ArrayUtils.printArray;

/**
 * @author weicong
 * @date 2018/3/27 0027
 */
public class ArrayTest2 {
    public static void main(String args[]) throws Exception {
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        System.out.println(array);
        ArrayUtils.printArray("数组排序", array);
        int index = Arrays.binarySearch(array, 1);
        System.out.println("元素 1 所在位置（负数为不存在）：" + index);
        int newIndex = -index - 1;
        array = insertElement(array, 1, newIndex);
        ArrayUtils.printArray("数组添加元素 1", array);
    }

    private static int[] insertElement(int original[],
                                       int element, int index) {
        int length = original.length;
        int destination[] = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index
                + 1, length - index);
        return destination;
    }
}
