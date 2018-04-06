package day7.thread.threadtest.threadtest12;

/**
 * 一个ThreadLocal的类
 * @author weicong
 * @date 2018/4/2 0002
 */
class Account{
    /**
     * ThreadLocal name 的get方法
     * @return 返回ThreadLocal的get方法
     */
    public String getName() {
        return name.get();
    }

    /**
     * ThreadLocal name 的set方法
     * @param name 传入从设置的name
     */
    public void setName(String name) {
        this.name.set(name);
    }

    private ThreadLocal<String> name=new ThreadLocal<>();
    private ThreadLocal<String> flag=new ThreadLocal<>();
    Account(String name ){
        this.name.set(name);
        System.out.println("---"+this.name.get());
    }

    /**
     * 使用完成后记得释放
     */
    public void clearThreadLocal(){
        name.remove();
        flag.remove();
    }
}
class MyThread extends Thread{
    /**
     * 线程引入account
     */
    private Account account;


    MyThread(String name, Account account){
        super(name);
        this.account=account;
    }
    @Override
    public void run() {
        /**
         * 设置多久需要替换
         */
        int forFlagNum=6;
        /**
         * 设置需要循环多少次
         */
        int forNum=10;

        for (int i = 0; i < forNum; i++) {
            // 当i == 6时输出将账户名替换成当前线程名
            if (i == forFlagNum){
                account.setName(getName());
            }
            // 当i==7 的时候清楚独自线程的变量
            if (i==forFlagNum+1){
                account.clearThreadLocal();
            }
            // 输出同一个账户的账户名和循环变量
            System.out.println(account.getName()
                    + " 账户的i值：" + i+"       ");
        }
    }
}
/**
 * @author weicong
 */
public class ThreadLocalTest1 {
    public static void main(String[] args) {
        Account account=new Account("初始名");

        new MyThread("线程甲",account).start();
        new MyThread("线程乙",account).start();

    }
}
