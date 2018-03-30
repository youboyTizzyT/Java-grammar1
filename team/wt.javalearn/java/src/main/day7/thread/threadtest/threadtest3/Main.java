package day7.thread.threadtest.threadtest3;

/**
 * @author weicong
 * @date 2018/3/28 0028
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个账户
        Account acct = new Account("1234567", 5000);
        // 模拟两个线程对同一个账户取钱
        new People(acct,"甲", 800).start();
        new People(acct,"乙", 800).start();
        new People(acct,"丙", 800).start();
        new People(acct,"丁", 800).start();
        new People(acct,"戊", 800).start();
        new People(acct,"庚", 800).start();
        new People(acct,"辛", 800).start();
    }
}
