package day7.thread.threadtest.threadtest4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁 位于jdk中concurrent包下的一种并发锁.
 * ReentrantReadWriteLock Reentrant的意思是可重入,后面会说.这个锁意思为可重入的读写锁
 * 读写锁的意思就是
 * 在没有写的时候,可以随时读,并发读都没问题
 * 在有写的时候,读的就不能读了,写完了才能读
 * @author weicong
 * @date 2018/3/28 0028
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        Data data=new Data();
        new Worker(data,false,"卢本伟伞兵一号").start();
        new Worker(data,true,"卢本伟天下第一").start();
    }
}

class Worker extends Thread{
    Data date;
    boolean isRead;
    Worker( Data date,boolean isRead,String name){
        super(name);
        this.date=date;
        this.isRead=isRead;
    }

    @Override
    public void run() {
        if (isRead){
            date.get(Thread.currentThread().getName());
        }else {
            date.set(Thread.currentThread().getName());
        }
    }
}
class Data{
    ReadWriteLock lock=new ReentrantReadWriteLock();
    Lock read=lock.readLock();
    Lock write=lock.writeLock();
    public void set(String name){
        write.lock();
        System.out.println(name+" set:begin " );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name+" set:end ");
            write.unlock();
        }
    }
    public void get(String name){
        read.lock();
        System.out.println(name+" get :begin ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name+ " get :end ");
            read.unlock();
        }
    }
}