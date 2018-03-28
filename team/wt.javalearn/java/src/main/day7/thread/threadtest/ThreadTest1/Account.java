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

    public Account(String accountNo, double balance){

        this.accountNo=accountNo;
        this.balance=balance;
    }
    public void draw(double drawAmount){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        return accountNo != null ? accountNo.equals(account.accountNo) : account.accountNo == null;
    }

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
