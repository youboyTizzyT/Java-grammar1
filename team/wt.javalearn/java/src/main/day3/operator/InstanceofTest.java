package day3.operator;

/**
 * 用来检验两个类型是否相同
 * @author weicong
 * @date 2018/3/20 0020
 */
public class InstanceofTest extends  Thread{
    public static void main(String[] args) {
        /*
         * instanceof比较的是两个类型
         */
        String name = "James";
        boolean result = name instanceof String; // 由于 name 是 String 类型，所以返回真
        System.out.println(result);

        Thread a = new InstanceofTest();
        boolean res =  a instanceof InstanceofTest;
        System.out.println( res);

        //InstanceofTest 是 Thread, Thread 不是 InstanceofTest 类型
        Thread b = new Thread();
         res =  b instanceof InstanceofTest;
        System.out.println( res);
    }
}
