package day3.modifier;

/**
 * @author weicong
 * @date 2018/3/20 0020
 */
public class TransientTest {
    /*
     * 序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。
     * 该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型
     */
    public transient int limit = 55;   // 不会持久化
    public int b; // 持久化
}
