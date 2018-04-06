package day7.thread.threadtest.threadtest12;

/**
 * ThreadLocal 的实现思想，每个线程维护一个 ThreadLocalMap 的映射表，映射表的 key 是 ThreadLocal 实例
 * 本身，value 是要存储的副本变量。ThreadLocal 实例本身并不存储值，它只是提供一个在当前线程中找到副本值的 key。
 * ThreadLocalMap 是采用的Hash思想来实现的
 * @author weicong
 * @date 2018/4/2 0002
 */
class ThreadLocalThread implements Runnable {
    /**
     * 我们看到虽然 threadLocal 是静态变量，但是每个线程都有自己的值，不会受到其他线程的影响。
     */
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    /**
     * value是静态的,线程之间共享的,
     */
    private static int value = 0;
    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100));
        value = (int) (Math.random() * 100);
        try {
            Thread.sleep(2000);
            System.out.printf(Thread.currentThread().getName() + ": threadLocal=%d, value=%d\n", threadLocal.get(), value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            threadLocal.remove();
        }

    }
}
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadLocalThread());
        Thread thread2 = new Thread(new ThreadLocalThread());
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
    }
}
