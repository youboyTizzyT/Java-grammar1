package day7.thread;

/**
 * 线程中的yield
 *  yield
 * 使线程从执行状态改变成可执行状态, 是线程编程可执行状态,以便其他相同优先级的线程有机会执行,
 *  注意: 再次执行调度程序决定的， 可以立刻会再次执行。。。
 *
 *  yield会释放资源锁吗？ (锁)
 *     yield不会释放资源所,当暂停后,等待调度程序再次调用,走完同步区域代码后才释放锁
 *
 * @author weicong
 * @date 2018/3/28 0028
 */
public class YieldThread extends Thread {
    YieldThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i <1000; i++) {
            System.out.println(getName() + "  " + i);
            if (i == 200) {
                // 当程序走到这里的时候会做一次让步,重新竞争cpu时间片
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        YieldThread yt1 = new YieldThread("高级");
        yt1.setPriority(Thread.MAX_PRIORITY);
        yt1.start();
        YieldThread yt2 = new YieldThread("低级");
        yt2.setPriority(Thread.MIN_PRIORITY);
        yt2.start();
    }
}
