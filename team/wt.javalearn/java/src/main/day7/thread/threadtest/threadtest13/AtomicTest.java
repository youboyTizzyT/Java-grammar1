package day7.thread.threadtest.threadtest13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic 的使用
 * @author weicong
 * @date 2018/4/2 0002
 */
public class AtomicTest {
    public AtomicInteger inc = new AtomicInteger(0);
    public Integer i = new Integer(1);

    public void increase() {
        inc.getAndAdd(1);
    }

    public static void main(String[] args) throws InterruptedException {
        Long begin=System.nanoTime();
        final AtomicTest test=new AtomicTest();
        final CountDownLatch cdl=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            new Thread(() -> {
                for(int j=0;j<1000;j++) {
                    test.increase();
//                        test.i++;
                }
                cdl.countDown();
            }).start();
        }
        cdl.await();

        System.out.println(test.inc.get());
        Long end=System.nanoTime();
        System.out.println(end-begin);
    }
}
