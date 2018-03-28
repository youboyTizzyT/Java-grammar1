package day7.thread.threadtest.threadtest5;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author weicong
 * @date 2018/3/28 0028
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        //每隔一段时间就触发异常
        exec.scheduleAtFixedRate(() -> {
            System.out.println("================");
//            throw new RuntimeException();
        }, 1000, 5000, TimeUnit.MILLISECONDS);
        //每隔一段时间打印系统时间，证明两者是互不影响的
        exec.scheduleAtFixedRate(() -> System.out.println(System.nanoTime()), 1000, 2000, TimeUnit.MILLISECONDS);
    }
}
