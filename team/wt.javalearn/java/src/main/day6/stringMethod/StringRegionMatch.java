package day6.stringMethod;

/**
 * 测试两个字符串区域是否相等
 * @author weicong
 * @date 2018/3/27 0027
 */
public class StringRegionMatch {
    public static void main(String[] args){
        String first_str = "Welcome to Microsoft";
        String second_str = "I work with microsoft";
        boolean match1 = first_str.
                regionMatches(11, second_str, 12, 9);
        boolean match2 = first_str.
                regionMatches(true, 11, second_str, 12, 9); //第一个参数 true 表示忽略大小写区别
        System.out.println("区分大小写返回值：" + match1);
        System.out.println("不区分大小写返回值：" + match2);
    }
}
