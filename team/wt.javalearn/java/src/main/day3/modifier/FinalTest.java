package day3.modifier;

/**
 * @author weicong
 * @date 2018/3/20 0020
 */
public class FinalTest{
    /*
     * final 变量能被显式地初始化并且只能初始化一次。
     * 被声明为 final 的对象的引用不能指向不同的对象。
     * 但是 final 对象里的数据可以被改变。也就是说
     * final 对象的引用不能改变，但是里面的值可以改变。
     * final 修饰符通常和 static 修饰符一起使用来创建类常量
     */
    final int value = 10;
    // 下面是声明常量的实例
    public static final int BOXWIDTH = 6;
    static final String TITLE = "Manager";

    public void changeValue(){
//        value = 12; //将输出一个错误
    }

    /*
     * 类中的 final 方法可以被子类继承，但是不能被子类修改。
     * 声明 final 方法的主要目的是防止该方法的内容被修改。
     * 如下所示，使用 final 修饰符声明方法。
     */
    public final void changeName(){
        // 方法体
    }
}

/*
 * final 类不能被继承，没有类能够继承 final 类的任何特性。
 */
final class Test {
    // 类体
}