package day6.stringMethod;

/**
 * 字符串反转
 * @author weicong
 * @date 2018/3/27 0027
 */
public class StringReverseExample {
    public static void main(String[] args){
        String string="lubenwei";
        String reverse = new StringBuffer(string).reverse().toString();
        System.out.println("字符串反转前:"+string);
        System.out.println("字符串反转后:"+reverse);
    }
}
