package day7.thread.threadtest.threadtest1;

/**
 * 执行类
 * @author weicong
 * @date 2018/3/28 0028
 */
public class Main {
    public static void main(String[] args) {
        // 创建一个账户
        Account account=new Account("中国银行",2000);
        // 模拟两个线程对同一个账户取钱
        People people =new People(account,"卢本伟",1500);
        People people1 =new People(account,"卢本伟1",1500);
        People people2 =new People(account,"卢本伟2",1500);
        People people3 =new People(account,"卢本伟3",1500);
        people.start();
        people1.start();
        people2.start();
        people3.start();

    }
}
