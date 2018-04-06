package day6.stringMethod;

/**
 * 字符串小写转大写
 * @author weicong
 * @date 2018/3/27 0027
 */
public class StringToUpperCaseEmp {
    public static void main(String[] args) {
        String str = "string baidu";
        String strUpper = str.toUpperCase();
        System.out.println("原始字符串: " + str);
        System.out.println("转换为大写: " + strUpper);
    }
}
