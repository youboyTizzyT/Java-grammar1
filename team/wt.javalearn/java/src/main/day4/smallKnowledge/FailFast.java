package day4.smallKnowledge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 快速失败fail-fast 当多个线程对集合进行结构上的改变的操作时，有可能会产生fail-fast机制
 * ConcurrentModificationException 应该仅用于检测 bug
 *
 * @author weicong
 * @date 2018/3/22 0022
 */
public class FailFast {
    private static List<Integer> list = new ArrayList<>();

    /**
     * @desc:线程one迭代list * @Project:test     * @file:FailFastTest.java     * @Authro:chenssy     * @data:2014年7月26日
     */
    private static class threadOne extends Thread {
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();
                System.out.println("ThreadOne 遍历:" + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @desc:当i == 3时，修改list     * @Project:test     * @file:FailFastTest.java     * @Authro:chenssy     * @data:2014年7月26日
     */
    private static class threadTwo extends Thread {
        public void run() {
            int i = 0;
            while (i < 6) {
                System.out.println("ThreadTwo run：" + i);
                if (i == 3) {
                    list.remove(i);
                }
                i++;
            }
        }
    }

    /**
     * 解决方案
     * 方案一：在遍历过程中所有涉及到改变modCount值得地方全部加上synchronized或者直接使用Collections.synchronizedList，
     * 这样就可以解决。但是不推荐，因为增删造成的同步锁可能会阻塞遍历操作。
     * 方案二：使用CopyOnWriteArrayList来替换ArrayList。推荐使用该方案。
     * JDK1.5开始 提供了两个CopyOnWrite 分别是CopyOnWriteArrayList和CopyOnWriteArraySet
     * CopyOnWriteArrayList ArrayList 的一个线程安全的变体其中所有可变操作（add、set 等等）都是通过对底层数组进行一次新的
     * 复制来实现的。 该类产生的开销比较大，但是在两种情况下，它非常适合使用。
     * 1 : 在不能或不想进行同步遍历，但又需要从并发线程中排除冲突时。
     * 2 : 当遍历操作的数量大大超过可变操作的数量时。遇到这两种情况使用CopyOnWriteArrayList来替代ArrayList再适合不过了。
     *
     *  CopyOnWrite这一般需要很大的开销 但是当遍历操作数量大大超过可变操作的数量时 线程安全的变体
     *  可变操作（add、set等等）都是通过对底层数组进行一次新的复制来实现的
     *  但是保证读的高性能,适用于以读为主的情况 CopyOnWrite后面详细讲解
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        new threadOne().start();
        new threadTwo().start();
    }

}
