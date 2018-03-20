package day3.loop;

/**
 * for循环 这里面会讲break和continue
 *
 * @author weicong
 * @date 2018/3/20 0020
 */
public class ForTest {
    /*
     *   for(初始化; 布尔表达式; 更新) {
     *   代码语句
     *   }
     */
    public static void main(String[] args) {
        for (int x = 10; x < 20; x = x + 1) {
            System.out.print("value of x : " + x);
            System.out.print("\n");
        }
        /*
         * jdk1.5 引入,foreach
         */
        int[] numbers = {10, 20, 30, 40, 50};

        for (int x : numbers) {
            System.out.print(x);
            System.out.print(",");
        }
        System.out.print("\n");
        String[] names = {"James", "Larry", "Tom", "Lacy"};
        for (String name : names) {
            System.out.print(name);
            System.out.print(",");
        }
        System.out.println();
        /*
         * 相信这两个关键字不需要我多介绍,运行一下自行体会
         */
        for (String name : names) {
            System.out.print(name);
            System.out.print(",");
            if ("Larry".equals(name)) {
                break;
            }
        }
        System.out.println();
        for (String name : names) {
            System.out.print(name);
            if ("Larry".equals(name)) {
                continue;
            }
            System.out.print("1");
            System.out.print(",");
        }
    }
}
