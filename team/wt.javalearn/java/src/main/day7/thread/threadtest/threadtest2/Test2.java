package day7.thread.threadtest.threadtest2;

/**
 * 对堆内存的一次i++安全性测验
 * @author weicong
 * @date 2018/3/28 0028
 */
public class Test2 {
    public static void main(String[] args) {
        Number number=new Number();
        // 这里应该采用线程池创建
        new Calculator1(number).start();
        new Calculator1(number).start();
        new Calculator1(number).start();
        new Calculator1(number).start();

    }
}
/**
 * @author weicong
 */
class Calculator1 extends Thread{
    private Number number;
    /**
     * 构造方法
     * @param number Number
     */
    Calculator1(Number number){
        this.number=number;
    }

    /**
     * 重写Thread的run方法
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"   "+number.getI());
        /*
         for循环次数
        */
        int forNum = 1000;
        for (int i = 0; i < forNum; i++) {
            number.setI(number.getI()+1);
        }
        System.out.println(Thread.currentThread().getName()+"   "+number.getI());
    }
}
class Number{

    private int i=0;

    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }

}
