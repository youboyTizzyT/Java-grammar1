package day7.thread.threadtest.threadtest9;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 栅栏锁 (CyclicBarrier)
 * @author weicong
 * @date 2018/4/2 0002
 *
 * 栅栏类似于闭锁，它能阻塞一组线程直到某个事件发生。 栅栏与闭锁的关键区别在于，所有的线程必须同时到达栅栏位置，才能继续
 * 执行。闭锁用于等待事件，而栅栏用于等待其他线程。
 *
 * 尝试运行一下这个例子,
 * 1,栅栏锁可以重复使用,只要线程await数到达Parties的值,所有线程将会一起释放 await也可以穿一个时间和时间格式进行等待,时间到了线程也会执行
 *
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        //如果将参数改为4，但是下面只加入了3个选手，这永远等待下去
        CyclicBarrier barrier = new CyclicBarrier(3);
        // 这里创建了一个有界直接提交的线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new Thread(new Runner(barrier, "1号选手")));
        executor.submit(new Thread(new Runner(barrier, "2号选手")));
        executor.submit(new Thread(new Runner(barrier, "3号选手")));

        executor.shutdown();
    }
}

class Runner implements Runnable {
    /**
     * 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)
     */
    private CyclicBarrier barrier;

    private String name;

    public Runner(CyclicBarrier barrier, String name) {
        super();
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (new Random()).nextInt(8));
            System.out.println(name + " 准备好了...");
            // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            System.out.println(barrier.getParties());
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 起跑！");
        try {
            Thread.sleep(1000 * (new Random()).nextInt(8));
            System.out.println(name + " 到达重点");
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + " 颁奖");
    }
}
