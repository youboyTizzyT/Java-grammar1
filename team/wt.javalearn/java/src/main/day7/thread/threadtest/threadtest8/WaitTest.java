package day7.thread.threadtest.threadtest8;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * wait和notify和notifyall
 * @author weicong
 * @date 2018/3/30 0030
 */
public class WaitTest {
    public static void main(String[] args) {
        Something something=new Something();
        DoSomething doSomething=new DoSomething(something,"张三");
        DoSomething doSomething1=new DoSomething(something,"李四");
        DoSomething doSomething2=new DoSomething(something,"王五");
        DoSomething doSomething3=new DoSomething(something,"马六");
        ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("pool-1-%d").build();
        // 设置一个无边界连接池,连接池大小为4,无边界,这里 可以改变一下这个连接池的大小. 看看打印的反应,结合线程池知识理解一下
        // cpu是如何调度,线程池如何工作.  如果线程池数目为2的每一步操作都了解了,那么恭喜你,线程池多线程锁的作用已经你参悟了
        ExecutorService pool=new ThreadPoolExecutor(2,
                2,
                30,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                threadFactory);
        pool.execute(doSomething);
        pool.execute(doSomething1);
        pool.execute(doSomething2);
        pool.execute(doSomething3);
        // 这里简单说一下线程池的shutdown和shutdownnow的区别 shutdown的意思就是等所有正在跑的线程和在线程池里面的线程
        // 跑完了再释放连接池, shutdownnow的意思就是stop掉所有的线程,立刻停止.
        pool.shutdown();
    }
}
class DoSomething extends Thread{
   private Something something;
   private String name;
    DoSomething(Something something,String name){
        this.name =name;
        this.something=something;
    }
    @Override
    public void run() {
        System.out.println(name+"线程开始准备工作");
        something.accessBlock(name);
    }
}
class Something{
    final private Object lock=new Object();
    private boolean isAccess=true;
    private boolean flag=true;

    /**
     *  所有线程走的方法
     * @param name
     */
    void accessBlock(String name){
        // 首先判断是否isAccess
        if (!isAccess) {
            // 锁住lock 使只能有一个人进行访问  当有人改变了isAccess后,其他人会一起抢lock这把锁
            synchronized (lock){
                System.out.println(name+"线程等待");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        isAccess=false;
        System.out.println(name+"线程开始操作");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "线程操作结束");

        if (flag){
            flag=false;
            synchronized (lock){
                lock.notify();
                flag=true;
            }
        }
    }
}

