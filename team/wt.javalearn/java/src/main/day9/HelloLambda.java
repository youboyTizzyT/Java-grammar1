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
        new Thread(()-> System.out.println("Hello Lambda!"))
    }
}
