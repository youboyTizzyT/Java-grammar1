package day9;

/**
 * alienware 每日更新java
 *
 * @author weicong
 * @time 2018/4/6
 */
public class HelloLambda {
    /**
     * Lambda只能使用与函数式方法，函数式接口
     * 首先使用Lambda创建一个多线程然后输出一段话
     */
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hello Lambda!")).start();
        /**
         * Lambda 表达式其实就是一个匿名内部类的一个推导
         * 如果不用Lambda表达式的话,那么代码将会是这样
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!");
            }
        }).start();
    }
}
