package day7.thread.threadtest.threadtest9;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport底层其实都是依赖Unsafe实现。
 * LockSupport是一个控制线程的工具.通过park 和 unpark来控制线程阻塞
 * 调用LockSupport.park();线程将会阻塞,LockSupport.unpark(t1);将会接触线程的阻塞
 * unpark需要传入一个线程
 *
 * @author weicong
 * @date 2018/4/2 0002
 */
class Thread1 extends Thread{
    public Thread1(String name){
        super.setName(name);
    }

    @Override
    public void run() {
            System.out.println("--------"+getName());
            LockSupport.park();
        System.out.println("++++++++"+getName());
    }
}
public class LockSupportTest {
    public static Object obj=new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1=new Thread1("t1");
        Thread1 t2=new Thread1("t2");
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);
        Thread.sleep(1000);
        LockSupport.unpark(t2);
    }

}
