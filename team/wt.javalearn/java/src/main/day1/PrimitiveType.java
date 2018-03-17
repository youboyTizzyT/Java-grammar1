package day1;

/**
 * 基本数据类型
 *
 * @author weicong
 * @date 2018/3/17 0017
 */
public class PrimitiveType {
    public static void main(String[] args) {
        /*
         * 首先了解java有什么数据类型
         * byte：
         *     byte 数据类型是8位、有符号的，以二进制补码表示的整数；
         *     最小值是 -128（-2^7）；
         *     最大值是 127（2^7-1）；
         *     包装类: java,lang,Byte
         *     默认值 : 0
         */
        byte a = 100;
        byte b = -50;
        System.out.println(a);// 100
        System.out.println(b);// -50
        System.out.println(Byte.MAX_VALUE);// 127
        System.out.println(Byte.MIN_VALUE);// -128
        /*
         * short：
         *      short 数据类型是 16 位、有符号的以二进制补码表示的整数
         *      最小值是 -32768（-2^15）；
         *      最大值是 32767（2^15 - 1）；
         *      包装类: java,lang,Short
         *      Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
         *      默认值是 0；
         */
         short s=10000;
         short r=-20000;
        System.out.println(s);// 10000
        System.out.println(r);// -20000
        System.out.println(Short.MAX_VALUE);// 32767
        System.out.println(Short.MIN_VALUE);// -32768
        /*
         * int：
         *      int 数据类型是32位、有符号的以二进制补码表示的整数；
         *      最小值是 -2,147,483,648（-2^31）；
         *      最大值是 2,147,483,647（2^31 - 1）；
         *      包装类: java,lang,Integer
         *      一般地整型变量默认为 int 类型；
         *      默认值是 0 ；
         */
         int i=1000000;
        System.out.println(i);// 1000000
        System.out.println(Integer.MAX_VALUE);// 2147483647
        System.out.println(Integer.MIN_VALUE);// -2147483648
        /*
         * lang:
         *      float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
         *      float 在储存大型浮点数组的时候可节省内存空间；
         *      默认值是 0.0f；
         *      包装类: java,lang,Lang
         *      浮点数不能用来表示精确的值，如货币；
         */
         float f1=234.5F;
         float f2=234.567891011121314f;
        System.out.println(f1);// 234.5
        System.out.println(f2);// 234.56789
        System.out.println(Float.MAX_VALUE);// 3.4028235E38
        System.out.println(Float.MIN_VALUE);// 1.4E-45
        /*
         * double：
         *      double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
         *      浮点数的默认类型为double类型；
         *      包装类: java,lang,Double
         *      double类型同样不能表示精确的值，如货币；
         */
         double d1=123.4567891011121314151617;
        System.out.println(d1);// 123.45678910111214
        /*
         * boolean：
         *      boolean数据类型表示一位的信息；
         *      只有两个取值：true 和 false；
         *      包装类: java,lang,Boolean
         *      这种类型只作为一种标志来记录 true/false 情况；
         *      默认值是 false；
         */
         boolean one=true;
        System.out.println(one);// true
        System.out.println(Boolean.FALSE);//
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.TYPE);
        /*
         * char：
         *      char类型是一个单一的 16 位 Unicode 字符；
         *      最小值是 \u0000（即为0）；
         *      最大值是 \uffff（即为65,535）；
         *      包装类: java,lang,Character
         *      char 数据类型可以储存任何字符；
         *      注意:在java中,用单引号是char类型,双引号是String类型
         */
         char letter='A';
         char letter1='3';
        System.out.println(letter);// A
        System.out.println(letter1);// 3
        System.out.println(Character.MIN_VALUE);// 输出不出来    \u0000
        System.out.println(Character.MAX_VALUE);// 因为不是utf-8 \uFFFF

    }
}
