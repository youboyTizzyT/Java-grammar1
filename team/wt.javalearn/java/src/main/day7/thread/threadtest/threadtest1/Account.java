package day7.thread.threadtest.threadtest1;

/**
 * 银行账号类
 * @author weicong
 * @date 2018/3/28 0028
 */
public class Account {
    /**
     * 账户编号
     */
    private String accountNo;
    /**
     * 当前账号里面的金钱
     */
    private double balance;

    /**
     * 构造方法
     * @param accountNo 账户编号
     * @param balance 账号里面的金钱
     */
     Account(String accountNo, double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }

    /**
     * 取钱操作
     * @param drawAmount 传入一个取钱数
     */
     void draw(double drawAmount){
        /*
         * 判断
         */
        if (balance>drawAmount){
            System.out.println(Thread.currentThread().getName()+"取钱成功!取出钞票:"+drawAmount);
            balance-=drawAmount;
            System.out.println("余额为:"+balance);
        }else {
            System.out.println("取钱失败");
        }
    }

    /**
     *  get set
     */
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * 重写equals
     * @param o 需要比较的对象
     * @return bool 返回一个bool值
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        return accountNo != null ? accountNo.equals(account.accountNo) : account.accountNo == null;
    }

    /**
     * 重写hashcode
     * @return 返回hashcode值
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNo != null ? accountNo.hashCode() : 0;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
