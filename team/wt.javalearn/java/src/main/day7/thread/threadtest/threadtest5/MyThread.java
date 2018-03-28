package day7.thread.threadtest.threadtest5;

/**
 * @author weicong
 * @date 2018/3/28 0028
 */
public class MyThread extends Thread{
    private String name;
    MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        int ii=0;
        for (int i = 0; i < 10000; i++) {
            ii+=i;
        }
        //pool-1-thread-1  pool的意思是线程池 1的意思是线程池的编号1 thread-1是线程池中线程的名字 并不是提交的线程名字
        System.out.println(Thread.currentThread().getName()+"正在运行...");
    }
}
