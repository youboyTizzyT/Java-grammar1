package day7.thread.threadtest.ThreadTest3;
/**
 * @author weicong
 * @date 2018/3/28 0028
 */
public class People extends Thread{
    private Account account;
    private double drawAmount;
    public People(Account account, String name, double drawAmount){
        super(name);
        this.account=account;
        this.drawAmount=drawAmount;
    }

    /**
     * 当多条线程修改同一个共享数据时，将涉及数据安全问题
     */
    @Override
    public void run() {
        account.draw(drawAmount);
    }
}
