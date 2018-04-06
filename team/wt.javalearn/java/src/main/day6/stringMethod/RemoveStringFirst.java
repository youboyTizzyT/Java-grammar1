package day6.stringMethod;

/**
 * 删除字符串中的一个字符
 * @author weicong
 * @date 2018/3/26 0026
 */
public class RemoveStringFirst {
    public static void main(String args[]) {
        String str = "this is Java";
        System.out.println(removeCharAt(str, 0));
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
