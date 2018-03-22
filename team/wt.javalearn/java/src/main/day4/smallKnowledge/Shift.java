package day4.smallKnowledge;

/**
 * @author weicong
 * @date 2018/3/22 0022
 */
public class Shift {
    public static void main(String[] args) {
        // >>：带符号右移。正数右移高位补0，负数右移高位补1
        int a=100;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a>>1));
        System.out.println(Integer.toBinaryString(a<<1));
        System.out.println(Integer.toBinaryString(a>>2));
        System.out.println(Integer.toBinaryString(a<<2));
        // >>>：无符号右移。无论是正数还是负数，高位通通补0。
        int b=-1;
        System.out.println(Integer.toBinaryString(b));
        int c=b>>>1;
        System.out.println(Integer.toBinaryString(b>>>1)+" "+c);
        int c1=b>>>16;
        System.out.println(Integer.toBinaryString(b>>>16)+" "+c1);
        /*
         * ^ 异或运算.
         * 比如这样一运算 3^5
         * 1先将3和5转换成二进制的11和101
         * 2然后进行分别位做运算
         *              0 1 1
         *      ^       1 0 1
         *    ----------------
         *              1 1 0
         * 3然后运算结果转换成10进制就是6
         */
        System.out.println(3^5);
        /*
         * 两个值的交换 a=10100001，b=00000110的值
         * a = a^b； 　　//a=10100111
         * b = b^a； 　　//b=10100001
         * a = a^b； 　　//a=00000110
         * 在汇编中xor a,a  就是a和a做异或,将变量置零
         * 判断两个整数a，b是否相等 return((a^b)==0)
         */
    }
}
