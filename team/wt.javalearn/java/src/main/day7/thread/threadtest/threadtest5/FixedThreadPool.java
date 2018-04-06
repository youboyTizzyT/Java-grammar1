package day7.thread.threadtest.threadtest5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小线程池
 * @author weicong
 * @date 2018/3/28 0028
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread("线程1号");
        Thread t2 = new MyThread("线程2号");
        Thread t3 = new MyThread("线程3号");
        Thread t4 = new MyThread("线程4号");
        Thread t5 = new MyThread("线程5号");
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();

    }
}
