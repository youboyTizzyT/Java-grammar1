package day7.thread;

/**
 * 守护线程 子线程都死了,守护线程将会结束
 * @author weicong
 * @date 2018/3/28 0028
 */
public class DaemonThread extends Thread {
    public DaemonThread(String name){
        super(name);
    }
    public void run() {
        DaemonThread dt=new DaemonThread("bbb");

        dt.start();
        // 这里将会死循环 导致线程一直存在
        while(true);
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread("aaa");
        t.setDaemon(true);
        t.start();
        // 当打完这次ok后将会结束main线程.因为t线程是守护线程,所以main线程结束t线程也会结束
        System.out.println("ok");
    }
}
