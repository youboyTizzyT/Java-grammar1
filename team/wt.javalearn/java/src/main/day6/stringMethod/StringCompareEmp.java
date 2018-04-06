package day6.stringMethod;

/**
 * 字符串比较
 * @author weicong
 * @date 2018/3/26 0026
 */
public class StringCompareEmp {
    public static void main(String args[]){
        String str = "Hello World";
        String anotherString = "hello world";
        Object objStr = str;
        /*
         * 来比较两个字符串，并返回字符串中第一个字母ASCII的差值
         */
        System.out.println( str.compareTo(anotherString) );
        System.out.println( str.compareToIgnoreCase(anotherString) );  //忽略大小写
        System.out.println( str.compareTo(objStr.toString()));
    }
}
