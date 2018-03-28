package day7.thread.threadtest.ThreadTest2;

/**
 * 对堆内存的一次i++安全性测验
 * @author weicong
 * @date 2018/3/28 0028
 */
public class Test2 {
    public static void main(String[] args) {
        Number number=new Number();
        new Calculator1(number).start();
        new Calculator1(number).start();
        new Calculator1(number).start();
        new Calculator1(number).start();

    }
}
class Calculator1 extends Thread{
    Number number;
    Calculator1(Number number){
        this.number=number;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"   "+number.getI());
        for (int i = 0; i < 1000; i++) {
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
