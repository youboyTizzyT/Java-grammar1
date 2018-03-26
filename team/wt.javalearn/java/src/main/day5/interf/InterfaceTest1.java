package day5.interf;

/**
 * 接口
 * 先说一下接口: 接口不是抽象类.但是有相似的点,也有不同点
 * 接口与抽象类相同: 1,接口和抽象类都不能用于实例化对象。
 * 接口和抽象类不同: 1,接口没有构造方法。
 *                   2,接口中所有的方法必须是抽象方法。 抽象类中可以存在不是抽象的方法
 *                   3,接口不能包含成员变量,除了 static 和 final 变量,如果包含,如果有会被隐式转换成 public static final 而
 *                     抽象类中可以包含各种
 *                   4,接口是实现(implements),类是继承(extend)
 *                   5,接口支持多实现。而抽象类只能单继承
 *                   6,接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法。
 * 当你关注一个事物的本质的时候，用抽象类；当你关注一个操作的时候，用接口。
 * 抽象类和接口都是在设计阶段设计的,也就是搭建框架的时候设计好.
 * @author weicong
 * @date 2018/3/26 0026
 */
public class InterfaceTest1  {
    public static void main(String args[]){
        MammalInt m = new MammalInt();
        m.eat();
        m.travel();
    }
}
interface Animal {
    public void eat();
    public void travel();
}
class MammalInt implements Animal{

    public void eat(){
        System.out.println("Mammal eats");
    }

    public void travel(){
        System.out.println("Mammal travels");
    }

    public int noOfLegs(){
        return 0;
    }
}
