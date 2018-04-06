package day7.thread.threadtest.threadtest14;

import java.util.concurrent.CountDownLatch;

/**
 * Volatile 内存屏障 当程序遇到volatile变量时必须再去内存中查看此值,不能在cpu缓存中直接拿来用
 * @author weicong
 * @date 2018/4/2 0002
 */
public class VolatileTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest test=new VolatileTest();
        final CountDownLatch cdl=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            new Thread(() -> {
                for(int j=0;j<1000;j++) {
                    test.increase();
                }
                cdl.countDown();
            }).start();
        }
        cdl.await();

        System.out.println(test.inc);
    }
}
