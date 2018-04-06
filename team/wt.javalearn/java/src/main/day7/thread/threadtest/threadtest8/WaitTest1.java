package day7.thread.threadtest.threadtest8;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * wait，notify，notifyAll必须在当前线程获得监视器时才能调用，即这些方法必须在同步块中才能调用。
 * 被阻塞的线程在被notify之后，并不是马上可以执行，而是“可执行”，要到获得锁之后才能真正开始执行。
 * @author weicong
 * @date 2018/3/30 0030
 */
public class WaitTest1 {
    public static void main(String[] args) {
        final Object lock="";
        ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("pool-1-%d").build();
        /**
         * 设置一个无边界连接池,连接池大小为4,无边界,这里 可以改变一下这个连接池的大小. 看看打印的反应,结合线程池知识理解一下
         * cpu是如何调度,线程池如何工作.  如果线程池数目为2的每一步操作都了解了,那么恭喜你,线程池多线程锁的作用已经你参悟了
         */
        ExecutorService pool=new ThreadPoolExecutor(2,
                2,
                30,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                threadFactory);
        ThreadTest99 threadTest99=new ThreadTest99("老王",lock);
        ThreadTest100 threadTest100=new ThreadTest100("小刘",lock);
        pool.execute(threadTest99);
        pool.execute(threadTest100);
        pool.shutdown();
    }
}
class ThreadTest99 extends Thread{
    private String name;
    private final Object lock;
    ThreadTest99(String name ,Object lock){
        this.name=name;
        this.lock=lock;
    }
    @Override
    public void run() {
        try {
        System.out.println(name+"开始执行");
        synchronized (lock){
            System.out.println(name + "获得锁,开始wait");
            lock.wait();
            System.out.println(name + "被唤醒,开始唤醒别人");
            lock.notifyAll();
            System.out.println(name+"结束run方法体.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ThreadTest100 extends Thread{
    private String name;
    private final Object lock;
    ThreadTest100(String name ,Object lock){
        this.name=name;
        this.lock=lock;
    }
    @Override
    public void run() {
        try {
            System.out.println(name +"开始线程 先睡5000ms");
            Thread.sleep(5000);
            System.out.println(name +"结束睡眠,获取锁");
            synchronized (lock){
                System.out.println(name + "获取锁成功 唤醒");
                lock.notify();
                System.out.println(name+"唤醒完成 睡5000ms");
                Thread.sleep(5000);
                System.out.println(name+"睡眠完成");
                lock.wait();
                System.out.println(name+"等待结束");
            }
            System.out.println(name+"释放锁");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}