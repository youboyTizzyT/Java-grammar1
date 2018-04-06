package day7.thread.threadtest.threadtest10;

/**
 * 自己定义线程异常
 * 运行一下自我体会
 * @author weicong
 * @date 2018/4/2 0002
 */
class MyExHandler implements Thread.UncaughtExceptionHandler {
    /**
     * 实现uncaughtException方法，该方法将处理线程的未处理异常
     * @param t 线程
     * @param e 异常
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " 线程出现了异常：" + e);
    }
}

/**
 * @author weicong
 */
public class ExHandler {
    public static void main(String[] args) {
        // 设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler
                (new MyExHandler());
        int a = 5 / 0;
        System.out.println("aaaaa程序正常结束！");
    }
}
