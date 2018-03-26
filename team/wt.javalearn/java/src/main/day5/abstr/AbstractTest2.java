package day5.abstr;

/**
 * 介绍抽象方法
 * @author weicong
 * @date 2018/3/26 0026
 */
public class AbstractTest2 extends Employee{
    private double salary; // Annual salary
    AbstractTest2(int salary){
        this.salary=salary;
    }
    @Override
    public double computePay() {
        return salary/52;
    }

    public static void main(String[] args) {
        AbstractTest2 abstractTest2=new AbstractTest2(52);
        System.out.println(abstractTest2.computePay());
    }
}

/**
 * 抽象类,多半都是框架中为了限制程序猿使用框架的规则.所以,程序必须读框架中所有概括.仔细看一下为什么框架中的某些设计.
 */
abstract class Employee
{
    private String name;
    private String address;
    private int number;

    /**
     * 作为抽象方法,必须具备:
     * 如果一个类包含抽象方法，那么该类必须是抽象类。
     * 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     * @return
     */
    public abstract double computePay();

    //其余代码
}