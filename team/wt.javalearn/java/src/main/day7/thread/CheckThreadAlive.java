package day7.thread;

/**
 * 查看线程是否存活
 * @author weicong
 * @date 2018/3/27 0027
 */
public class CheckThreadAlive {
    /**
     * 今天,开始总结线程 之后的整理路线,线程->io->socket
     * 首先介绍一下线程的所有状态 观看 线程状态图
     * 如何创建一个线程,java提供了3种方法来创建一个线程
     * 1,通过实现 Runnable 接口；
     * 2,通过继承 Thread 类本身；
     * 3,通过 Callable 和 Future 创建线程。
     * 当然我们可以用isAlive方法来检验线程是否还存活
     */
    public static void main(String[] args) {
        Thread1 r1 = new Thread1( "Thread-1");
        r1.start();
        Thread1 r2 = new Thread1( "Thread-2");
        r2.start();


        ThreadDemo t1 = new ThreadDemo( "Thread-1");
        t1.start();

        ThreadDemo t2 = new ThreadDemo( "Thread-2");
        t2.start();
        System.out.println("t2.isAlive():"+t2.isAlive());
    }
}

/**
 * 这就是一个线程类.实现了Runnable接口,重写了run方法.就是一个线程类.当然也可以继承Thread类也可以通过Callable 和 Future 创建线程
 * 这里就不多演示了
 */
class Thread1 implements Runnable{
    /**
     * 每创建一个线程必须传入一个名字
     */
    private Thread t;
    private String name;
    Thread1(String name){
        this.name=name;
        System.out.println(name+"线程进入了创建状态");
    }
    @Override
    public void run() {
        System.out.println(name+"线程进入了运行状态");
        // 当run方法里面执行的内容很少的情况下看不出并行
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println(name+"线程运行结束准备进入了死亡状态");
    }
    public void start(){
        if (t == null) {
            t = new Thread (this, name);
            t.start ();
        }
        System.out.println(name+"线程进入了可运行状态");
    }
}

/**
 * 创建一个线程类,使用继承Thread来创建
 */
class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    @Override
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
