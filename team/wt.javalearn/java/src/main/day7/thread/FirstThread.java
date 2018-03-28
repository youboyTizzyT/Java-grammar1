package day7.thread;

/**
 * 第一个线程
 * @author weicong
 * @date 2018/3/28 0028
 */
public class FirstThread extends Thread{
    private int i;
    FirstThread (String name){
        // 这里调用父类的构造方法,设置线程名字
        super(name);
    }
    @Override
    public void run() {
        for (; i <2 ; i++) {
            System.out.println(this.getName()+" "+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(Thread.currentThread().getName()+ " "+i);
            if (i==1){
                new FirstThread("aaaaa").start();
                new FirstThread("bbbbb").start();

            }
        }
    }
}
