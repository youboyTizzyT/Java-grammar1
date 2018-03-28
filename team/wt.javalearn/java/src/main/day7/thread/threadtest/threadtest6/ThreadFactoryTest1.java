package day7.thread.threadtest.threadtest6;

//import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author weicong
 * @date 2018/3/28 0028
 */
public class ThreadFactoryTest1 {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        //gracefully shutdown
        pool.shutdown();
    }
}
