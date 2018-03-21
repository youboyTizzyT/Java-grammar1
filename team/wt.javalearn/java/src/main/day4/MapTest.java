package day4;

import java.util.HashMap;
import java.util.Map;
/**
 * Map
 * @author weicong
 * @date 2018/3/20 0020
 */
public class MapTest {
    /* 首先,简介一下Map Map覆盖了Object的equals和hashcode方法,以确定Map对象的等价性
     * Map类的方法有clear(),remove(Object key),put(Object key, Object value),putAll(Map t)
     * 方法名字就是他们的作用.就不一一示范了.
     * Java 自带了各种 Map 类:
     * HashMap
     * Hashtable
     * Properties
     * LinkedHashMap
     * IdentityHashMap
     * TreeMap
     * WeakHashMap
     * ConcurrentHashMap
     * 接下来讲解重要的几个Map
     */
    // 首先Map的使用 由于Map不能创建实例,我们采用hashMap
    public static void main(String[] args) {
        /*
         * 接下来了解一下HashMap的原理
         * 它根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的
         * 。 HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同
         * 时写HashMap，可能会导致数据的不一致。如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具
         * 有线程安全的能力，或者使用ConcurrentHashMap。下面的例子已经证明我们的hashmap是无序的
         *
         * HashMap是利用数组与链表结合的形式构建的。竖列为数组结构，默认初始数量为16（1<<4）个
         * 横列为链表结构用于解决散列冲突的问题。当数组中有值得元素超过了装载因子的比例（默认为0.75）时，会引发扩容的操
         * 作。此操作是为了避免元素过满时引起的链表长度过长，从而影响查找性能。见图HashMap内存结构
         *
         * 我们也可以查看HashMap类的原码
         * transient关键字是不被序列化的
         * 专门说一个HashMap里面的一个变量 transient int modCount;
         * HashMap对象被修改次数，防止出现多个线程修改出现的线程不一致性，每次修改HashMap的值时，都会自增。当使用Iterator
         * 操作HashMap时，会用此值与Iterator内部的值做一次比较，从而判断HashMap有没有被其他线程修改。故建议每次遍历HashMap
         * 时都使用Iterator。
         * 疑问,为什么HashMap不是安全的?
         */
        Map m1 = new HashMap();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");
        System.out.println("Map Elements");
        System.out.print("\t" + m1);

    }

}
