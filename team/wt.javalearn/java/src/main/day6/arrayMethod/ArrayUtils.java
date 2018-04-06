package day6.arrayMethod;

/**
 * @author weicong
 * @date 2018/3/27 0027
 */
 class ArrayUtils {
    /**
     * 打印元素
     * @param message
     * @param array
     */
     static void printArray(String message, int array[]) {
        System.out.println(message
                + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if(i != 0){
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
