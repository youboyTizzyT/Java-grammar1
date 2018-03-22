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
         * 1.7中modCount是使用volatile修饰的,但是jdk1.8并没有使用volatile
         * 1.7保证线程之间修改的可见性 判断modCount跟expectedModCount是否相等，如果不相等就表示已经有其他线程修改了Map：
         * 如果不一样则fail-fast策略
         *
         */
        HashMap m1 = new HashMap();
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
         *
         * 在concurrentHashMap中的put 1.7
         * 1,计算key的hash值.
         * 2.根据hash值找到segment的位置, hash 是 32 位，无符号右移 segmentShift(28) 位，剩下低 4 位，
         *   然后和 segmentMask(15) 做一次与操作，也就是说 j 是 hash 值的最后 4 位，也就是槽的数组下标
         * 3.如果是segment[j]没有初始化ensureSegment(j) 对 segment[j] 进行初始化
         * 4. 插入新值到 槽 s 中
         */
        concurrentHashMap.put("111","111");
        /*
         * segment放入entry的时候:
         * 1,在往segment写之前,需要先获取该segment的独占锁.
         * 2,然后往里面插入,finally释放锁
         *
         * 初始化槽: ensureSegment
         * ConcurrentHashMap 初始化的时候会初始化第一个槽 segment[0]，对于其他槽来说，在插入第一个值的时候进行初始化
         * 但是如果两个线程同时初始化会为了保证并发,只会有一个成功. 使用 while 循环，内部用 CAS，当前线程成功设值或其他线程成功设值后，退出
         * ensureSegment(int k) 比较简单，对于并发操作使用 CAS 进行控制
         *
         * 在往某个 segment 中 put 的时候，首先会调用 node = tryLock() ? null : scanAndLockForPut(key, hash, value)
         * 就是说先进行一次 tryLock() 快速获取该 segment 的独占锁，如果失败，那么进入到 scanAndLockForPut 这个方法来获取锁。
         * 具体分析这个方法中是怎么控制加锁的
         *
         * 获取写入锁: scanAndLockForPut
         * 直接while循环获取锁.
         * 重试次数如果超过 MAX_SCAN_RETRIES（单核1多核64），那么不抢了，进入到阻塞队列等待锁 直到获取锁后返回
         * 这个方法就是做了一件事，那就是获取该 segment 的独占锁，如果需要的话顺便实例化了一下 node。
         *
         * 扩容:rehash  扩容后，容量为原来的 2 倍。
         * 能触发扩容的地方,put,该方法不需要考虑并发，因为到这里的时候，是持有该 segment 的独占锁的 和hashmap相似,
         *
         * 在concurrentHashMap中put如何保证线程安全的
         * 初始化槽,
         */
        concurrentHashMap.get("111");
        /*
         * 对于concurrentHashMap来说,get方法的确简单,
         * 计算 hash 值，找到 segment 数组中的具体位置，或我们前面用的“槽”槽中也是一个数组，根据 hash 找到数组中具体的
         * 位置到这里是链表了，顺着链表进行查找即可 get并没有实现读锁的业务,随时读,
         *
         * 最后说一下并发问题.
         * 既然ConcurrentHashMap保证了并发性,然而我们看到的只有put有并发性,但是get没有保证并发,
         * put操作保证线程安全性
         * 1.初始化槽，这个我们之前就说过了，使用了 CAS 来初始化 Segment 中的数组
         * 2.添加节点到链表的操作是插入到表头的，所以，如果这个时候 get 操作在链表遍历的过程已经到了中间，是不会影响的。
         * 当然，另一个并发问题就是 get 操作在 put 之后，需要保证刚刚插入表头的节点被读取，这个依赖于 setEntryAt 方法中
         * 使用的 UNSAFE.putOrderedObject。
         * 3.扩容。扩容是新创建了数组，然后进行迁移数据，最后面将 newTable 设置给属性 table。所以，如果 get 操作此时也在
         * 进行，那么也没关系，如果 get 先行，那么就是在旧的 table 上做查询操作；而 put 先行，那么 put 操作的可见性保证就
         * 是 table 使用了 volatile 关键字
         *
         * remove操作
         * remove有兴趣的可以自己看原码自行分析
         * get 操作需要遍历链表，但是 remove 操作会”破坏”链表。
         * 如果 remove 破坏的节点 get 操作已经过去了，那么这里不存在任何问题。
         * 如果 remove 先破坏了一个节点，分两种情况考虑。 1、如果此节点是头结点，那么需要将头结点的 next 设置为数组该位置
         * 的元素，table 虽然使用了 volatile 修饰，但是 volatile 并不能提供数组内部操作的可见性保证，所以源码中使用了
         * UNSAFE 来操作数组，请看方法 setEntryAt。2、如果要删除的节点不是头结点，它会将要删除节点的后继节点接到前驱节点
         * 中，这里的并发保证就是 next 属性是 volatile 的。
         *
         * jdk1.8
         * 1、先根据key的hash值计算书其在table的位置 i。
         * 2、检查table[i]是否为空，如果为空，则返回null，否则进行3
         * 3、在table[i]存储的链表(或树)中开始遍历比对寻找，如果找到节点符合key的，则判断value是否为null来决定是否是更新
         *    oldValue还是删除该节点。
         */
        concurrentHashMap.remove("111");


    }

}
