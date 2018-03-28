package day7.thread;

import java.util.Random;

/**
 * Join线程
 * @author weicong
 * @date 2018/3/28 0028
 */
public class JoinThread extends Thread {
    private JoinThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if (i%100==0) {
                System.out.println(this.getName());
            }
        }System.out.println(this.getName()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public static void main(String[] args) throws Exception {
        // 首先main线程创建一个新线程并启动 这个线程没有被join 他属于随缘执行
        new JoinThread("新线程").start();
        // 进入for循环
        for (int i = 0; i < 3; i++) {
            // 每次循环创建一个线程
            JoinThread jt = new JoinThread("被Join的线程"+i);
            // 每次启动.  第一次循环打印到下面的jt.start()时,此时会有两根线程被start
            jt.start();
            // join后,新线程将不会等待jt执行完毕后再执行,main会等待jt执行完毕后再执行\
            // join后,相当于main线程调用了jt线程里面的wait.去等待jt线程走完.
            jt.join();
        }
    }
}
