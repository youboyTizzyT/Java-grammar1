package day7.thread.threadtest.threadtest1;

/**
 * 用户类
 * @author weicong
 * @date 2018/3/28 0028
 */
public class People extends Thread{
    private Account account;
    private double drawAmount;
    public People(Account account,String name,double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }

    /**
     * 当多条线程修改同一个共享数据时，将涉及数据安全问题
     */
    @Override
    public void run() {
        // 直接调用account对象的draw方法来执行取钱
        // 同步方法的同步监视器是this，this代表调用draw()方法的对象。
        // 也就是说：线程进入draw()方法之前，必须先对对account象的加锁。
//        synchronized (account) {
            account.draw(drawAmount);
//        }
    }
}
