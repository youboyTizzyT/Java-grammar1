package day7.thread.threadtest.threadtest9;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 用法
 * @author weicong
 * @date 2018/4/2 0002
 * 这个程序涉及到2根线程. 一根是main线程,一根是自己创建的执行Task任务的线程
 * 首先 main线程 创建了一个线程并启动,创建的线程睡了1000毫秒.然后main线程调用cdl.wait一天,然后线程做了两次countDown CountDownLatch这个锁被打开了
 * 简单说一下闭锁的作用
 *      主要是同步方法,可以延迟线程的进度知道线程达到某个状态,相当于就是一个大门,当大门打开的时候,所有线程才允许通过.
 * CountDownLatch是java5里闭锁的一个实现,允许一个或者多个线程等待某个事件的发生,CountDownLatch有一个正数计数器,countDown方法
 * 就是对计数器减一,await的线程就会阻塞直到计数器为0或者等待线程中断或者超时.
 *
 * CountDownLatch java实现简单了解一下.
 * 在jdk底层CountDownLatch 里有一个Sync内部类继承了AbstractQueuedSynchronizer 虽然我也不知道干嘛的,可能是一个抽象同步队列(看名字像)
 * 这个Sync里面一共有几个方法,getCount(获取count数值) ,tryAcquireShared(具体情况我也没仔细往下看),tryReleaseShared(这个方法
 * 通过cas操作也即是CompareAndSet操作对数组count赋值.cas操作保证了CountDownLatch的大门是安全的.) 不能复用
 */
public class CountDownTest {
    static CountDownLatch cdl=new CountDownLatch(2);
    public static void main(String[] args) {
        Task ts=new Task();
        Thread t=new Thread(ts);
        t.start();
        System.out.println("==========");
        try {
            cdl.await(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }
}
class Task implements  Runnable{
    @Override
    public void run() {
        try {
            System.out.println("------------");
            Thread.sleep(1000);
            System.out.println("++++++++++++");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            CountDownTest.cdl.countDown();
            CountDownTest.cdl.countDown();
        }
    }
}
