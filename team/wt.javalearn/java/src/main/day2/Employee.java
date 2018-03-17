package day2;

/**
 * 实例变量在整个类内部是可访问的，而不管实例变量声明在类的哪个位置
 * @author weicong
 * @date 2018/3/17 0017
 */
public class Employee{
    public String name; // 类变量
    private double salary; // 类变量
    // 构造方法,创建对象的时候设置对象的name字段
    public Employee (String empName){
        name = empName;
    }
    // 类方法,对外公开
    public void setSalary(double empSal){
        salary = empSal;
    }
    // 类方法,对外公开
    public void printEmp(){
        System.out.println("name:" + name);
        System.out.println("salary:" + salary);
    }
    // main主函数
    public static void main(String args[]){
        // 创建一个实体
        Employee empOne = new Employee("RUNOOB");
        // 调用实体方法
        empOne.setSalary(1000);
        empOne.printEmp();
        // 调用实体变量
        System.out.println(empOne.salary);
    }

}
