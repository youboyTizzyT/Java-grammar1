package day1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 结合使用,java中数据类型转换大全
 * @author weicong
 * @date 2018/3/17 0017
 */
public class ZhuanHuan {
    public static void main(String[] args) {
        /*
         * 将字符串转化为整型
         * Integer.parseInt和 Integer.valueOf 不同，
         * 前者生成的是整型，
         * 而后者是一个Integer对象，所以要通过intValue()来获得对象的值；
         */
        String str="3";
        int i1 = Integer.parseInt(str);
        int i2 = Integer.valueOf(str).intValue();
        /*
         * 将字符串转化为整型
         * Double, Float, Long 的方法大同小异.
         */
        String string = String.valueOf(i1);
        String string1 = Integer.toString(i1);
        String string2 = "" + i1 ;
        /*
         * float型转换为double型：
         * F1.doubleValue()为Float类的返回double值型的方法
         */
        float f1=100.00f;
        Float F1=new Float(f1);
        double d1=F1.doubleValue();
        /*
         * double型转换为int型
         */
        double d=100.00;
        Double D1=new Double(d1);
        int i=D1.intValue();
        /*
         * int型转换为double型：
         * 直接可以实现转换,因为double比int精确
         */
        int i3=200;
        double d2=i1;
        /*
         * 从网上扒下来,感觉特别好用,收藏,日后忘记了可以回来看看 url:http://blog.csdn.net/ching_zhi/article/details/53673989
         * string->byte
         * Byte static byte parseByte(String s)
         *
         * byte->string
         * Byte static String toString(byte b)
         *
         * char->string
         * Character static String to String (char c)
         *
         * string->Short
         * Short static Short parseShort(String s)
         *
         * Short->String
         * Short static String toString(Short s)
         *
         * String->Integer
         * Integer static int parseInt(String s)
         *
         * Integer->String
         * Integer static String tostring(int i)
         *
         * String->Long
         * Long static long parseLong(String s)
         *
         * Long->String
         * Long static String toString(Long i)
         *
         * String->Float
         * Float static float parseFloat(String s)
         *
         * Float->String
         * Float static String toString(float f)
         *
         * String->Double
         * Double static double parseDouble(String s)
         *
         * Double->String
         * Double static String toString(Double)
         */
    }

}
