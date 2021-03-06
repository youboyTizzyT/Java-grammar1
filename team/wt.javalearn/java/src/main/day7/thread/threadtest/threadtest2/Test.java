package day7.thread.threadtest.threadtest2;

/**
 * 对静态区的一次i++
 * @author weicong
 * @date 2018/3/28 0028
 */
public class Test {
    public static  int i=0;
    public static void main(String[] args) {
        // 这里应该采用线程池创建线程
        new Calculator().start();
        new Calculator().start();
        new Calculator().start();
        new Calculator().start();
        // 每一个线程对i进行1000次增加 四个线程执行完了,如果安全的话将会每次得到4000这个数字
        System.out.println(i);
        // 那只能说明run方法体内循环次数太少
    }
}
class Calculator extends Thread{
    /**
     * for循环次数
     */
    private int forNum=1000;

    /**
     * 重写Thread的run方法
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"   "+Test.i);
        for (int i = 0; i < forNum; i++) {
            Test.i++;
        }
        System.out.println(Thread.currentThread().getName()+"   "+Test.i);
    }
}
