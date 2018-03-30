package day7.thread.threadtest.threadtest7;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author weicong
 * @date 2018/3/29 0029
 */
public class ReentrantLockTest1 {
    public static void main(String[] args) {
        Account account=new Account("95599200901215522",500000-48000);
        ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("pool-1-%d").build();
        ExecutorService pool=new ThreadPoolExecutor(
                2,
                2,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
                );

        Thread t1 = new DrawThread("张三", account, 110000);
        Thread t2 = new SaveThread("李四", account, 36000);
        Thread t3 = new DrawThread("王五", account, 27000);
        Thread t4 = new SaveThread("老张", account, 6000);
        Thread t5 = new DrawThread("老牛", account, 13000);
        Thread t6 = new SaveThread("胖子", account, 20000);
        Thread t11 = new DrawThread("张三", account, 110000);
        Thread t12 = new SaveThread("李四", account, 36000);
        Thread t13 = new DrawThread("王五", account, 27000);
        Thread t14 = new SaveThread("老张", account, 6000);
        Thread t15 = new DrawThread("老牛", account, 13000);
        Thread t16 = new SaveThread("胖子", account, 20000);
        Thread t21 = new DrawThread("张三", account, 110000);
        Thread t22 = new SaveThread("李四", account, 36000);
        Thread t23 = new DrawThread("王五", account, 27000);
        Thread t24 = new SaveThread("老张", account, 6000);
        Thread t25 = new DrawThread("老牛", account, 13000);
        Thread t26 = new SaveThread("胖子", account, 20000);
        Thread t31 = new DrawThread("张三", account, 110000);
        Thread t32 = new SaveThread("李四", account, 36000);
        Thread t33 = new DrawThread("王五", account, 27000);
        Thread t34 = new SaveThread("老张", account, 6000);
        Thread t35 = new DrawThread("老牛", account, 13000);
        Thread t36 = new SaveThread("胖子", account, 20000);
        Thread t41 = new DrawThread("张三", account, 110000);
        Thread t42 = new SaveThread("李四", account, 36000);
        Thread t43 = new DrawThread("王五", account, 27000);
        Thread t44 = new SaveThread("老张", account, 6000);
        Thread t45 = new DrawThread("老牛", account, 13000);
        Thread t46 = new SaveThread("胖子", account, 20000);

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t11);
        pool.execute(t12);
        pool.execute(t13);
        pool.execute(t14);
        pool.execute(t15);
        pool.execute(t16);
        pool.execute(t21);
        pool.execute(t22);
        pool.execute(t23);
        pool.execute(t24);
        pool.execute(t25);
        pool.execute(t26);
        pool.execute(t31);
        pool.execute(t32);
        pool.execute(t33);
        pool.execute(t34);
        pool.execute(t35);
        pool.execute(t36);
        pool.execute(t41);
        pool.execute(t42);
        pool.execute(t43);
        pool.execute(t44);
        pool.execute(t45);
        pool.execute(t46);

        pool.shutdown();

    }
}
class Account{
    private String id;
    private int cash;
    private Lock lock=new ReentrantLock();
    Condition save=lock.newCondition();
    private Condition draw=lock.newCondition();
    Account(String id,int cash){
        this.id=id;
        this.cash=cash;
    }
    public void save(int cash,String name){
        lock.lock();
        if (cash>0){
            this.cash+=cash;
            System.out.println(name+"存款"+cash+". 当前余额为:"+this.cash);
        }
        draw.signalAll();
        lock.unlock();

    }
    public void draw(int cash,String name){
        try {
        lock.lock();
        if (this.cash<cash){
            System.out.println(name+"取钱失败  [余额不足]");
            draw.await();
        }
        this.cash-=cash;
            System.out.println(name+"取钱"+cash+". 当前余额为:"+this.cash);
            save.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

}

class SaveThread extends Thread{
    Account account;
    int cash;
    public SaveThread(String name,Account account,int cash){
        super(name);
        this.account=account;
        this.cash=cash;

    }
    @Override
    public void run() {
        account.save(cash,this.getName());
    }
}
class DrawThread extends Thread{
    Account account;
    int cash;
    public DrawThread(String name,Account account,int cash){
        super(name);
        this.account=account;
        this.cash=cash;

    }
    @Override
    public void run() {
        account.draw(cash,this.getName());
    }
}
