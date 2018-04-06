package day7.thread.threadtest.threadtest6;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * ThreadPoolExecutor详解
 * 构造函数参数解释如下:
 * corePoolSize - 池中所保存的线程数，包括空闲线程。 这两个就不详细解说了
 * maximumPoolSize-池中允许的最大线程数。
 * keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
 *                 这里注意穿的参数是long型.
 * unit - keepAliveTime 参数的时间单位。
 *        可以穿TimeUnit类里面的NANOSECONDS(纳秒),MICROSECONDS(微秒),MILLISECONDS(毫秒),SECONDS(秒),MINUTES(分钟),HOURS(小时),DAYS(天)
 *        这里,我们知道计算机是以毫秒最低单位的.
 * workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute方法提交的 Runnable任务。线程池始终首选将请求加入队列，而不添加新的线程
 *             queue的类型有三种.
 *                      SynchronousQueue:直接提交.工作队列的默认选项,它将任务直接提交给线程而不保持它们。在此，如果不存在
 *                      可用于立即运行任务的线程，则试图把任务加入队列将失败，因此会构造一个新的线程。此策略可以避免在处
 *                      理可能具有内部依赖性的请求集时出现锁。直接提交通常要求无界 maximumPoolSizes 以避免拒绝新提交的任
 *                      务。当命令以超过队列所能处理的平均数连续到达时，此策略允许无界线程具有增长的可能性
 *                      LinkedBlockingQueue:无界队列,将导致在所有 corePoolSize 线程都忙时新任务在队列中等待。这样，创建的
 *                      线程就不会超过 corePoolSize。（因此，maximumPoolSize的值也就无效了。）当每个任务完全独立于其他任
 *                     界队列；例如，在 Web页服务器中。这种排队可用于处理瞬态突发
 *                      请求，当命令以超过队列所能处理的平均数连续到达时， 务，即任务执行互不影响时，适合于使用无此策略允许无界线程具有增长的可能性。
 *                      ArrayBlockingQueue:有界队列,有助于防止资源耗尽，但是可能较难调整和控制。队列大小和最大池大小可能
 *                      需要相互折衷：使用大型队列和小型池可以最大限度地降低 CPU 使用率、操作系统资源和上下文切换开销，但
 *                      是可能导致人工降低吞吐量。如果任务频繁阻塞（例如，如果它们是 I/O边界），则系统可能为超过您许可的
 *                      更多线程安排时间。使用小型队列通常要求较大的池大小，CPU使用率较高，但是可能遇到不可接受的调度开销
 *                      ，这样也会降低吞吐量。
 * threadFactory - 执行程序创建新线程时使用的工厂。
 *                 这个一般都自己做,并且使线程的名字带上线程池的名字和线程自己的名字,阿里规范中要求必须使用threadFactory
 * handler - 由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。
 *           在ThreadPoolExecutor中已经默认包含了4中策略
 *           CallerRunsPolicy: 这个策略就是直接调用线程本身的run方法来进行运行.
 *           AbortPolicy: 处理程序遭到拒绝将抛出运行时RejectedExecutionException这种策略直接抛出异常，丢弃任务
 *           DiscardPolicy: 不能执行的任务将被删除 几乎一样，也是丢弃任务，只不过他不抛出异常
 *           DiscardOldestPolicy: 如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）
 *                                该策略就稍微复杂一些，在pool没有关闭的前提下首先丢掉缓存在队列中的最早的任务，然后重新尝试运行该任务。这个策略需要适当小心。
 *                                设想:如果其他线程都还在运行，那么新来任务踢掉旧任务，缓存在queue中，再来一个任务又会踢掉queue中最老任务。
 *
 * @author weicong
 * @date 2018/3/28 0028
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        /**
         * 解释一下这个线程池:
         * 池中所保存的线程数为2个
         * 池中允许的最大线程数为3个
         * 最长等待时间为30秒
         * 采用直接提交
         * 使用自己定义的namedThreadFactory线程工厂
         * 超出线程范围和队列内容采取CallerRunsPolicy策略
         *
         * 假如,当前有两根线程已经在运行
         *      1. 此时又来了一个线程,根据线程池始终首选将请求加入队列，而不添加新的线程,他将会添加这根线程到线程池.然后
         *      因为是直接提交模式,直接将这根线程提交到线程池 当前线程池为2根线程 队列中1线程
         *      2. 此时又来了一个任务，且核心2个线程还没有忙完，OK，接下来首先尝试1中描述，但是由于使用的SynchronousQueue，
         *      所以一定无法加入进去。
         *      3. 此时便满足了上面提到的“如果无法将请求加入队列，则创建新的线程，除非创建此线程超出maximumPoolSize，在
         *      这种情况下，任务将被拒绝。”，所以必然会新建一个线程来运行这个任务。
         *      4.暂时还可以，但是如果这三个任务都还没完成，连续来了两个任务，第一个添加入queue中，后一个呢？queue中无法
         *      插入，而线程数达到了maximumPoolSize，所以只好执行异常策略了。
         * 所以在使用SynchronousQueue通常要求maximumPoolSize是无界的，这样就可以避免上述情况发生（如果希望限制就直接使用
         * 有界队列）。对于使用SynchronousQueue的作用jdk中写的很清楚：此策略可以避免在处理可能具有内部依赖性的请求集时出现锁。
         */
        new ThreadPoolExecutor(
                2,
                3,
                30,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                namedThreadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
        /**
         * 解释一下这个线程池:
         * 池中所保存的线程数为10个
         * 池中允许的最大线程数为50个
         * 最长等待时间为30秒
         * 采用无界队列
         * 使用自己定义的namedThreadFactory线程工厂
         * 超出线程范围和队列内容采取CallerRunsPolicy策略
         *
         * 因为上面提到如果无法将请求加入队列，则创建新的线程这个条件,除非创建此线程超出 maximumPoolSize,在这种情况下，任务将被拒绝
         * 于无界队列来说，总是可以加入的（资源耗尽，当然另当别论）。换句说，永远也不会触发产生新的线程！corePoolSize大小
         * 的线程数会一直运行，忙完当前的，就从队列中拿任务开始运行。所以要防止任务疯长，比如任务运行的实行比较长，而添加
         * 任务的速度远远超过处理任务的时间，而且还不断增加，不一会儿就爆了。
         * 因为无边界,所以一般情况corePoolSize和maximumPoolSize的数值一样,因为永远不可能创建完了线程池再去创建新线程
         */
        new ThreadPoolExecutor(
                10,
                50,
                30,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                namedThreadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());

        /**
         * 解释一下这个线程池:
         * 池中所保存的线程数为2个
         * 池中允许的最大线程数为4个
         * 最长等待时间为30秒
         * 采用有界队列 长度为2
         * 使用自己定义的namedThreadFactory线程工厂
         * 超出线程范围和队列内容采取CallerRunsPolicy策略
         *
         * 假设，所有的任务都永远无法执行完。
         * 于首先来的A,B来说直接运行，接下来，如果来了C,D，他们会被放到queue中，如果接下来再来E,F，则增加线程运行E，F。但
         * 是如果再来任务，队列无法再接受了，线程数也到达最大的限制了，所以就会使用拒绝策略来处理。
         */
        new ThreadPoolExecutor(
                2,
                4,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                namedThreadFactory,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
