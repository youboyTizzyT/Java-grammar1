package day2;

/**
 * 不可以从一个static方法内部发出对非static方法的调用
 * @author weicong
 * @date 2018/3/17 0017
 */
public class Xix {
    // 静态成员
    public static String string="static成员";
    // 普通成员
    public String string2="非static成员";
    // 静态方法
    public static void method(){
        string="sss";
        //string2="sss"; // 编译报错,因为静态方法里面只能调用静态方法或静态成员
        //method2();
        System.out.println("这是static方法,static方法与对象无关");
    }

    // 普通方法
    public void method2(){
        string ="string1";
        string2="string2";
        method(); //非静态方法里面可以发出对static方法的调用
        System.out.println("这是非static方法,此方法必须和指定的对象关联起来才起作用");
    }
    public static void main(String[] args) {
        Xix x=new Xix();
        x.method2();// 引用调用普通方法
        x.method();// 引用调用静态方法
        /* 输出:
         * 这是static方法,static方法与对象无关
         * 这是非static方法,此方法必须和指定的对象关联起来才起作用
         * 这是static方法,static方法与对象无关
         *
         * 记忆:
         * 不可以。因为非static方法是要与对象关联在一起的，必须创建一个对象后，才可以在该对象上进行方法调用，
         * 而static方法调用时不需要创建对象，可以直接调用。也就是说，当一个static方法被调用时，可能还没有创建
         * 任何实例对象，如果从一个static方法中发出对非static方法的调用，那个非static方法是关联到哪个对象上的
         * 呢？这个逻辑无法成立，所以，一个static方法内部发出对非static方法的调用
         */
    }
}
