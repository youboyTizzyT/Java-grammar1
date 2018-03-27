package day7.thread;

/**
 * 查看线程是否存活
 * @author weicong
 * @date 2018/3/27 0027
 */
public class CheckThreadAlive {
    /*
     * 今天,开始总结线程 之后的整理路线,线程->io->socket
     * 首先介绍一下线程的所有状态 观看 线程状态图
     * 如何创建一个线程,java提供了3种方法来创建一个线程
     * 1,通过实现 Runnable 接口；
     * 2,通过继承 Thread 类本身；
     * 3,通过 Callable 和 Future 创建线程。
     */
    public static void main(String args[]) {
        Thread1 R1 = new Thread1( "Thread-1");
        R1.start();

        Thread1 R2 = new Thread1( "Thread-2");
        R2.start();
    }
}

/**
 * 这就是一个线程类.实现了Runnable接口,重写了run方法.就是一个线程类.当然也可以继承Thread类也可以通过Callable 和 Future 创建线程
 * 这里就不多演示了
 */
class Thread1 implements Runnable{
    // 每创建一个线程必须传入一个名字
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
