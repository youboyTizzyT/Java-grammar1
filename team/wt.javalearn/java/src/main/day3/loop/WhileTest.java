package day3.loop;

/**
 * while循环 这里不多解释
 *
 * @author weicong
 * @date 2018/3/20 0020
 */
public class WhileTest {
    public static void main(String[] args) {
        int x = 10;
        while (x < 20) {
            System.out.print("value of x : " + x);
            x++;
            System.out.print("\n");
        }
        //do while
        do {
            System.out.print("value of x : " + x);
            x++;
            System.out.print("\n");
        } while (x < 20);
    }
}
