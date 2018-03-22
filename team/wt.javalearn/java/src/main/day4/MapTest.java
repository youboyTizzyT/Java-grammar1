package day4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        /*
         * HashMap 的内存结构见HashMap内存结构图.当然,那仅仅是一个示意图.因为没有考虑到扩容的情况.
         * 大方向上,HashMap里面是一个数组 数组中每一个元素是一个单项链表,
         * 每一个存放的实体是一个Entry实例 Entry 包含四个属性：key, value, hash 值和用于单向链表的 next
         * capacity：当前数组容量，始终保持 2^n，可以扩容，扩容后数组大小为当前的 2 倍。
         * loadFactor：负载因子，默认为 0.75。
         * threshold：扩容的阈值，等于 capacity * loadFactor
         *
         * 浅谈hashmap的put方法,
         * 这里不展示源代码,想深究的可以自己看底层代码只需要找到HashMap类然后找到方法putVal方法就可以
         * 这里只说一下put基本操作.
         * 1.判断此map是否为空,为空就 初始化数组 大小,大小为threshold
         * 2.如果key为null,讲把这个entry放到table[0]中
         * 3,求key的hash
         * 4.找到对 应数组下标
         * 5.遍历一下对应下标处的链表,看是否有重复key已经存在,如果有直接覆盖并且返回旧值
         * 5,如果不存在重复的key,将次entry添加到链表中,
         *
         * 这里面运用到了初始化数组,我们继续看一下初始化数组做了什么
         * 在HashMap下的inflateTable(int size)这个方法中
         * 1.首先保证了数组大小一定是2的n次方 如果这样初始化new HashMap(20) 那么他的初始数组大小为32
         * 2.计算扩容阈值: capacity * loadFactor
         * 3.初始化.
         * Java7 和 Java8 的 HashMap 和 ConcurrentHashMap 都有相应的要求，只不过实现的代码稍微有些不同，后面再看到的时候就知道了
         *
         * 还运用到了计算具体数组位置
         * 这个方法很简单，简单说就是取 hash 值的低 n 位。如在数组长度为 32 的时候，其实取的就是 key 的 hash 值的低 5 位，作为它在数组中的下标位置
         *
         * 还运用到了添加节点到链表中
         * 首先会判断,hashmap大小是否达到了阈值，并且新值要插入的数组位置已经有元素了，那么要扩容
         * 扩容下面说
         * 然后其实就是将新值放到链表的表头，然后 size++
         *
         * 添加节点到链表中运用到了数组扩容  扩容就是用一个新的大数组替换原来的小数组，并将原来数组中的值迁移到新的数组中
         * 由于是双倍扩容，迁移过程中，会将原来 table[i] 中的链表的所有节点，通过hash值分拆到新的数组的 newTable[i] 和
         * newTable[i + oldLength] 位置上。如原来数组长度是 16，那么扩容后，原来 table[0] 处的链表中的所有元素会被分配到
         * 新数组中 newTable[0] 和 newTable[16] 这两个位置。
         */
        m1.get("Ayan");
        /*
         * hashmap的get方法相对于put很简单.
         * 三部曲
         * 1,根据 key 计算 hash 值。
         * 2,找到相应的数组下标：hash & (length – 1)。
         * 3,遍历该数组位置处的链表，直到找到相等(==或equals)的 key
         */
        // 既然我们说到了HashMap.那么我们也应该了解了解ConcurrentHashMap
        /*
         * ConcurrentHashMap 和 HashMap 思路是差不多的，但是因为它支持并发操作，所以要复杂一些。
         * 整个 ConcurrentHashMap 由一个个 Segment 组成，Segment 代表”部分“或”一段“的意思，所以很多地方都会将其描述为分段锁
         * 如果你对concurrenthashmap有所了解后,对你是用的对象存储给予最高性能的初始化参数.如果不了解,还是老老实实使用无参初始化
         */
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        /*
         * 第二种初始化,直接分配整个大小, initialCapacity 初始容量，这个值指的是整个 ConcurrentHashMap 的初始容量，实际操作的时候需要平均分给每个 Segment
         */
        ConcurrentHashMap concurrentHashMap1 =new ConcurrentHashMap(10);
        /*
         * 第三种和第四种初始化,一起说,不仅仅能狗初始化容量,也可以加上他的负载因子,但是这个扩容和hashmap的扩容不一样
         * Segment 数组不可以扩容，所以这个负载因子是给每个 Segment 内部使用的 ,第三个变量是他的并行级别,也就是并发数,
         * 也就是我们之前说的Segment数,默认是16,也就是说,之前3种的初始化,最多支持同时16个线程进行并发写,只要他们操作在
         * 分布不同的Segment,这个值初始化后,不可改变,不可扩容.所以,如果你对你手头的活足够了解,你可以根据需求去定这个值.
         */
        ConcurrentHashMap concurrentHashMap2 =new ConcurrentHashMap(10,0.8f,16);
        /*
         * 初始化完成后,我们得到了一个Segment数组,
         * 如果你使用无参构造了ConcurrentHashMap 那么
         * Segment数组长度为16,不可扩容,
         * Segment[i] 的默认大小为2,负载因子为0.75,得出初始阔值,为1.5,所以,在同一个Segment中插入一个元素,不会扩容,第二个会扩容一次
         * segmentShift 的值为32-4=28,segmentMask =16-1=15  移位数和掩码
         * 只初始化了segment[0],其他位置是null
         */




    }

}
