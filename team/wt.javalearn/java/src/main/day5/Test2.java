package day5;

/**
 * 多态面试题 (腾讯)
 * 口诀  变量多态看左边，方法多态看右边， 静态多态看左边。
 * @author weicong
 * @date 2018/3/26 0026
 */
public class Test2 {
    public static void main(String[] args){
        A classA = new B();
        System.out.println(classA.a);
        classA.fun();
    }
}
class A {
    public int a = 0;
    public void fun(){
        System.out.println("-----A-----");
    }
}
class B extends A{
    public int a = 1;
    public void fun(){
        System.out.println("-----B-----");
    }
}
