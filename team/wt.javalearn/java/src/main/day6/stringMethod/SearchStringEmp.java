package day6.stringMethod;

/**
 *  字符串搜索
 * @author weicong
 * @date 2018/3/27 0027
 */
public class SearchStringEmp {
    public static void main(String[] args) {
        String strOrig = "Google lubenwei Taobao";
        int intIndex = strOrig.indexOf("lubenwei");
        if(intIndex == - 1){
            System.out.println("没有找到字符串 lubenwei");
        }else{
            System.out.println("lubenwei 字符串位置 " + intIndex);
        }
    }
}
