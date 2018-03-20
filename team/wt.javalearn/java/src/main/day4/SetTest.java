package day4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set
 * @author weicong
 * @date 2018/3/20 0020
 */
public class SetTest {
    /* 注重独一无二的性质,该体系集合可以知道某物是否已近存在于集合中,不会存储重复的元素
     * 首先,在Set中没有一样的元素,那么如何判定相等呢?
     *
     * 引用到堆上同一个对象的两个引用是相等的。如果对两个引用调用hashCode方法，会得到相同的结果，如果对象所属的类没有覆
     * 盖Object的hashCode方法的话，hashCode会返回每个对象特有的序号（java是依据对象的内存地址计算出的此序号），所以两个
     * 不同的对象的hashCode值是不可能相等的。
     * 如果想要让两个不同的Person对象视为相等的，就必须覆盖Object继下来的hashCode方法和equals方法，因为Object  hashCode
     * 方法返回的是该对象的内存地址，所以必须重写hashCode方法，才能保证两个不同的对象具有相同的hashCode，同时也需要两个
     * 不同对象比较equals方法会返回true
     */
    public static void main(String[] args) {
        //Set 集合存和取的顺序不一致。
        Set hs = new HashSet();
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");
        boolean ret=hs.add("汉和防务");
        System.out.println(hs);
        // [舰船知识, 世界军事, 兵器知识, 汉和防务]
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // 输出: false
        System.out.println(ret);
        // 接下来了解一下HashSet
        /*
         * 哈希表边存放的是哈希值。HashSet存储元素的顺序并不是按照存入时的顺序是按照哈希值来存的所以取数据也是按照哈希值取得。
         * HashSet不存入重复元素的规则.使用hashcode和equals
         * HashSet会通过元素的hashcode（）和equals方法进行判断元素是否重复 当存入元素时.hashset会拿元素的hashcode比较所有.
         * 如果对象的hashCode值是不同的，那么HashSet会认为对象是不可能相等的
         * 如果对象的hashCode值相同了,那么HashSet会再比较equals值是否相同,如果相同那么认为重复了,如果不相同那么认为是新元素.
         * 因此我们自定义类的时候需要重写hashCode，来确保对象具有相同的hashCode值。
         * 这也就是为什么我们继承一个类如果重写了hashcode就必须也要重写equals这个道理
         */
        // TreeSet
        TreeSet<String> ts = new TreeSet<>();
        ts.add("ccc");
        ts.add("aaa");
        ts.add("ddd");
        ts.add("bbb");
        // 输出: [aaa, bbb, ccc, ddd]
        System.out.println(ts);
        /*
         * TreeSet 采用的是红黑树! ! !
         * 红黑数不多说了,面试都问过,笔者曾经被问过无数次.
         * 这里就不多了解红黑树了 不了解的需要去温故一下或者知新去吧.
         * 红黑树的特性里面有一条是左小右大.那么,我们如何比较.
         * 方式一：元素自身具备比较性
         *          元素自身具备比较性，需要元素实现Comparable接口，重写compareTo方法，也就是让元素自身具备比较性，这种
         *          方式叫做元素的自然排序也叫做默认排序。
         * 方式二：容器具备比较性
         *          当元素自身不具备比较性，或者自身具备的比较性不是所需要的。那么此时可以让容器自身具备。需要定义一个类
         *          实现接口Comparator，重写compare方法，并将该接口的子类实例对象作为参数传递给TreeMap集合的构造方法。
         * 注意: 当Comparable比较方式和Comparator比较方式同时存在时，以Comparator的比较方式为主
         * 注意:注意：在重写compareTo或者compare方法时，必须要明确比较的主要条件相等时要比较次要条件。（假设姓名和年龄一
         * 直的人为相同的人，如果想要对人按照年龄的大小来排序，如果年龄相同的人，需要如何处理？不能直接return 0，因为可能
         * 姓名不同（年龄相同姓名不同的人是不同的人）。此时就需要进行次要条件判断（需要判断姓名），只有姓名和年龄同时相等
         * 的才可以返回0.）
         * 通过return 0来判断唯一性。
         * 显而易见,TreeSet是通过compareTo或者compare方法中的来保证元素的唯一性。
         * 在SetTest1和SetTest2中将会表现成两种让元素自身具备比较性和让容器自身具备比较性，自定义比较器。
         */
    }
}
