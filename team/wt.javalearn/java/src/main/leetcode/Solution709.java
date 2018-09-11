package leetcode;

/**
 * 转换成小写字母
 * Create by weicong on 2018/9/11
 * @author 小米电脑
 */
public class Solution709 {
    public static String toLowerCase(String str) {
        char[] ret=new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>=65&&str.charAt(i)<=90){
                ret[i]= (char) (str.charAt(i)+32);
            }else {
                ret[i]=str.charAt(i);
            }
        }
        return String.valueOf(ret);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }
}
