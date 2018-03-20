package day3.modifier;

/**
 * static 修饰符
 * @author weicong
 * @date 2018/3/20 0020
 */
public class InstanceCounter {
    /*
     * 静态变量：
     * static 关键字用来声明独立于对象的静态变量，
     * 无论一个类实例化多少对象，它的静态变量只有
     * 一份拷贝。 静态变量也被称为类变量。局部变
     * 量不能被声明为 static 变量。
     */
    private static int numInstances = 0;
    /*
     * 静态方法：
     * static 关键字用来声明独立于对象的静态方法。
     * 静态方法不能使用类的非静态变量。静态方法从
     * 参数列表得到数据，然后计算这些数据。
     * 注意:static函数与普通函数：static函数在内存中只有一份，普通函数在每个被调用中维持一份拷贝。
     * @return
     */
    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " +
                InstanceCounter.getCount() + " instances");
        for (int i = 0; i < 500; ++i){
            new InstanceCounter();
        }
        System.out.println("Created " +
                InstanceCounter.getCount() + " instances");
        /*
         * 输出
         * Starting with 0 instances
         * Created 500 instances
         */
    }
}
