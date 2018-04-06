package day7.thread;

/**
 * 重复start
 * 线程的生命周期是个不可循环的过程，一个线程对象结束了不能再次start
 * @author weicong
 * @date 2018/3/28 0028
 */
public class StartDead extends Thread {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    public static void main(String[] args) {
        StartDead sd = new StartDead();
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " " + i);
            if (i == 20) {
                sd.start();
                System.out.println(sd.isAlive());
            }
            // 继承Thread实例化线程不能重复start 可以改成实现Runnable，后用new Thread(robot).start 就可以启动多次了
            if (i > 20 && !sd.isAlive()) {
                sd.start();
            }
        }
    }
}
