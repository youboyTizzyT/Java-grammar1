package day2;

/**
 * 类的静态数据成员值被所有对象共享，
 * 任何对象都可以访问类的静态数据成员。
 * 但是他们使用的是同一个数据，操作的是
 * 同一块内存，无论哪个对象修改了它，对
 * 其他对象来说，他已经变了。
 * @author weicong
 * @date 2018/3/20 0020
 */
class Q{
    static int i;
    void change(int i1){i=i1;}
}
public class Test {
    public static void main(String args[]){
        Q.i=10;
        Q a=new Q();
        Q b=new Q();
        System.out.println(Q.i+","+a.i+","+b.i);//10,10,10
        a.change(40);
        System.out.println(Q.i+","+a.i+","+b.i);//40,40,40
        b.i+=10;
        System.out.println(Q.i+","+a.i+","+b.i);//50,50,50
    }
}
