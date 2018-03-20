package day3.modifier;

/**
 * @author weicong
 * @date 2018/3/20 0020
 */
abstract class AbsCaravan {
    /*
     *抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
     * 一个类不能同时被 abstract 和 final 修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
     * 抽象类可以包含抽象方法和非抽象方法
     */
    private double price;
    private String model;
    private String year;
    /*
     * 抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。
     * 抽象方法不能被声明成 final 和 static。
     * 任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。
     * 如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类可以不包含抽象方法。
     */
    public abstract void goFast(); //抽象方法
    public abstract void changeColor();
    public void aaa(){
        // 方法体
    }
}
class SubClass extends AbsCaravan{
    // 实现抽象方法
    @Override
    public void goFast() {

    }

    @Override
    public void changeColor() {

    }
}
