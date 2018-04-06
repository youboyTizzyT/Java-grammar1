package day7.thread.threadtest.threadtest5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weicong
 * @date 2018/3/28 0028
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread("线程1号");
        Thread t2 = new MyThread("线程2号");
        Thread t3 = new MyThread("线程3号");
        Thread t4 = new MyThread("线程4号");
        Thread t5 = new MyThread("线程5号");
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();
    }
}
