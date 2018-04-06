package day7.thread;

/**
 * 线程的优先级
 * 优先级,并不是有比当前高的就会先执行高的,优先级是一个比重.就是高的一定占用cpu多.
 * @author weicong
 * @date 2018/3/28 0028
 */
public class PriorityThread extends Thread{
    private PriorityThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + ",其优先级是："
                    + getPriority() + ",循环变量的值为:" + i);
        }
    }
    public static void main(String[] args) {
        Thread.currentThread().setPriority(5);
        for (int i = 0; i < 30; i++) {
            if (i == 10) {
                PriorityThread low = new PriorityThread("低级");
                low.start();
                System.out.println("创建之初的优先级:"
                        + low.getPriority());
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (i == 20) {
                PriorityThread high = new PriorityThread("高级");
                high.start();
                System.out.println("创建之初的优先级:"
                        + high.getPriority());
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
