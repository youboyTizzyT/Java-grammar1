package day6.stringMethod;

/**
 * 查找字符串最后一次出现的位置
 * @author weicong
 * @date 2018/3/26 0026
 */
public class SearchlastString {
    public static void main(String[] args) {
        String strOrig = "Hello world ,Hello lubenwei";
        /*
         * strOrig.lastIndexOf(Stringname) 来查找子字符串 Stringname 在 strOrig 出现的位置
         */
        int lastIndex = strOrig.lastIndexOf("lubenwei");
        if(lastIndex == - 1){
            System.out.println("没有找到字符串 lubenwei");
        }else{
            System.out.println("lubenwei 字符串最后出现的位置： "+ lastIndex);
        }
    }
}
