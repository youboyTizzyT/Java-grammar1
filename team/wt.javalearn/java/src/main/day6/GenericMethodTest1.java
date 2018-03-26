package day6;

/**
 * 泛型 泛型方法  使用泛型返回最大元素
 * @author weicong
 * @date 2018/3/26 0026
 */
public class GenericMethodTest1 {
    /**
     * 比较三个值并返回最大值
     * @param x 传入参数
     * @param y 传入参数
     * @param z 传入参数
     * @param <T> 定义一个T类型的泛型 他必须是继承ComParable  意思就是ComParable是他的最大范围,传入的T类型必须在它的子类
     * @return 返回三个参数中最大的
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; // 假设x是初始最大值
        if (y.compareTo(max) > 0) {
            max = y; //y 更大
        }
        if (z.compareTo(max) > 0) {
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    public static void main(String args[]) {
        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n", 3, 4, 5, maximum(3, 4, 5));
        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
    }
}
