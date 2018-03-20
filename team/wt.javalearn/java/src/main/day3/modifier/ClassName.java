package day3.modifier;

/**
 * java 修饰符
 * @author weicong
 * @date 2018/3/20 0020
 */
public class ClassName {
    /*
     * private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
     */
    private boolean myFlag;
    /*
     * default (即缺省，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
     */
    static final double weeks = 9.5;
    /*
     * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。
     */
    protected static final int BOXWIDTH = 42;
    /*
     * public : 对所有类可见。使用对象：类、接口、变量、方法
     */
    public int SSS=1;
    // 主方法
    public static void main(String[] arguments) {
        // 方法体
    }
}


