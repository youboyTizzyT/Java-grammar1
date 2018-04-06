package day5.abstr;

import day2.Employee;

/**
 * 主要介绍抽象类
 * @author weicong
 * @date 2018/3/26 0026
 */
public abstract class AbstractTest1 {
    private String name;
    private String address;
    private int number;
    public AbstractTest1(String name, String address, int number)
    {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public double computePay()
    {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + this.name
                + " " + this.address);
    }
    public String toString()
    {
        return name + " " + address + " " + number;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String newAddress)
    {
        address = newAddress;
    }
    public int getNumber()
    {
        return number;
    }

    public static void main(String[] args) {
         /* 以下是不允许的，会引发错误 */
//        AbstractTest1 e = new AbstractTest1("George W.", "Houston, TX", 43);// 会报错

//        System.out.println("\n Call mailCheck using Employee reference--");
//        e.mailCheck();
        // 但是我们可以实例化Salary这个类
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        AbstractTest1 e = new Salary("John Adams", "Boston, MA", 2, 2400.00);

        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();

        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
    }
}
class Salary extends AbstractTest1{
    private double salary; //Annual salary
    public Salary(String name, String address, int number, double
            salary)
    {
        super(name, address, number);
        setSalary(salary);
    }
    public void mailCheck()
    {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }
    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double newSalary)
    {
        if(newSalary >= 0.0)
        {
            salary = newSalary;
        }
    }
    public double computePay()
    {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }
}

