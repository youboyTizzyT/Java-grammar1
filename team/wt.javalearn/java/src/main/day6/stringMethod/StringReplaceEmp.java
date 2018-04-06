package day6.stringMethod;

/**
 * 字符串替换
 * @author weicong
 * @date 2018/3/27 0027
 */
public class StringReplaceEmp {
    public static void main(String args[]){
        String str="Hello World He";
        System.out.println( str.replace( 'H','W' ) );
        System.out.println( str.replaceFirst("He", "Wa") );
        System.out.println( str.replaceAll("He", "Ha") );
    }
}
