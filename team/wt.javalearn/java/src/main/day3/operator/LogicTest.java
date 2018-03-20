package day3.operator;

/**
 * 逻辑运算符
 * @author weicong
 * @date 2018/3/20 0020
 */
public class LogicTest {
    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;
        System.out.println("a && b = " + (a&&b));
        System.out.println("a || b = " + (a||b) );
        System.out.println("!(a && b) = " + !(a && b));
        /*
         * 当使用与逻辑运算符时，在两个操作数都为true时，结果才为true，
         * 但是当得到第一个操作为false时，其结果就必定是false，这时候就不会再判断第二个操作了。
         */
        int c = 5;//定义一个变量；
        boolean d = (c<4)&&(c++<10);
        System.out.println("使用短路逻辑运算符的结果为"+d);
        System.out.println("a的结果为"+c);
    }
}
