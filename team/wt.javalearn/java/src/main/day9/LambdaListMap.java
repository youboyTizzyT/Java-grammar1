package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author weicong
 * @date 2018/4/17 0017
 */
public class LambdaListMap {
    public static void main(String[] args) {
        /**
         * 在日常开发中经常用到,甚至说没有哪个java代码中没有集合类
         * 我们现在可以对比一下集合的迭代.首先,正常的遍历
         */
        List<String> languages=new ArrayList<>();
        languages.add("java");
        languages.add("scala");
        languages.add("python");
        for (String language :languages) {
            System.out.println(language);
        }
        /**
         * 以上是正常遍历数组进行操作,那么如果使用Lambda呢?
         */
        languages.forEach(X-> System.out.println(X));
        /**
         * 是不是很简单.接下来看一下lambda表达式中的map,
         * map函数可以说是函数式编程里最重要的一个方法了。map的作用是将一个对象变换为另外一个。在我们的例子中，
         * 就是通过map方法将cost增加了0,05倍的大小然后输出。
         */
        // 这个操作 并不会真正改变languages数组内的元素
        languages.stream().map(x->x+"123123").forEach(x-> System.out.println(x));
        // 这样就会真正改变languages数组内的元素了
//        languages=languages.stream().map(x->x+"123123").collect(Collectors.toList());
//        System.out.println(languages);
        /**
         * 现在有这么一个需求,给所有的玩家的金钱加一,那么我们用map函数写起来会很简单.
         */
        List<Integer> players= Arrays.asList(15,84,65,26,48,95);
        players.stream().map(x->x+1).forEach(x-> System.out.println(x));
        /**
         * 那么现在都加一个,我们如果想求数组内所有数组的集合怎么办?现在有一个reduce函数,那么结合上面的也就是我们经常说的mapreduce
         */
        Integer allCost=players.stream().map(x->x+1).reduce((sum,x)->sum+x).get();
        System.out.println(allCost);
        /**
         * 如果我们用for循环来做这件事情
         */
        Integer all=0;
        for (Integer cost:players) {
            cost=cost+1;
            all+=cost;
        }
        System.out.println(all);
        /**
         * 是不是很高深
         *
         * 接下来介绍一下filter操作吧
         * filter也是我们经常使用的一个操作。在操作集合的时候，经常需要从原始的集合中过滤掉一部分元素。
         * 一下将会过滤出来所有x>30的元素
         */
        System.out.println(players);
        List<Integer> newPlayers=players.stream().filter(x->x>30).collect(Collectors.toList());
        System.out.println(newPlayers);
        /**
         * 除了在语言层面支持函数式编程风格，Java 8也添加了一个包，叫做 java.util.function。它包含了很多类，用来支持Java
         * 的函数式编程。其中一个便是Predicate，使用 java.util.function.Predicate 函数式接口以及lambda表达式，可以向API方
         * 法添加逻辑，用更少的代码支持更多的动态行为。Predicate接口非常适用于做过滤。
         */
        System.out.println("Language starts with J: ");
        filterTest(languages,x -> x.startsWith("J"));
        System.out.println("\nLanguage ends with a: ");
        filterTest(languages,x -> x.endsWith("a"));
        System.out.println("\nAll languages: ");
        filterTest(languages,x -> true);
        System.out.println("\nNo languages: ");
        filterTest(languages,x -> false);
        System.out.println("\nLanguage length bigger three: ");
        filterTest(languages,x -> x.length() > 4);
        /**
         * 去重 用lambda也会非常便捷
         */
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
        /**
         * 计算集合元素的最大值,最小值,总和,以及平均值
         * IntStream、LongStream 和 DoubleStream 等流的类中，有个非常有用的方法叫做 summaryStatistics() 。
         * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistic s，描述流中元素的各种摘要数据。
         * 在本例中，我们用这个方法来计算列表的最大值和最小值。它也有 getSum() 和 getAverage() 方法来获得列表的所有元素的总和及平均值。
         */
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        System.out.println("Count numbers : " + stats.getCount());
        /**
         * Lambda表达式 vs 匿名类
         * 既然lambda表达式即将正式取代Java代码中的匿名内部类，那么有必要对二者做一个比较分析。
         * 一个关键的不同点就是关键字 this。匿名类的 this 关键字指向匿名类，而lambda表达式的 this 关键字指向包围lambda表达式的类。
         * 另一个不同点是二者的编译方式。Java编译器将lambda表达式编译成类的私有方法。使用了Java 7的 invokedynamic 字节码指令来动态绑定这个方法。
         *
         * (1): lambda表达式仅能放入如下代码：预定义使用了 @Functional 注释的函数式接口，自带一个抽象函数的方法，
         * 或者SAM（Single Abstract Method 单个抽象方法）类型。这些称为lambda表达式的目标类型，可以用作返回类型，
         * 或lambda目标代码的参数。例如，若一个方法接收Runnable、Comparable或者 Callable 接口，都有单个抽象方法，
         * 可以传入lambda表达式。类似的，如果一个方法接受声明于 java.util.function 包内的接口，
         * 例如 Predicate、Function、Consumer 或 Supplier，那么可以向其传lambda表达式。
         *
         * (2): lambda表达式内可以使用方法引用，仅当该方法不修改lambda表达式提供的参数。本例中的lambda表达式可以换为方法引用，因为这仅是一个参数相同的简单方法调用。
         */
        // 使用方法引用
        players.forEach(System.out::println);
        /**
         * 然而，若对参数有任何修改，则不能使用方法引用，而需键入完整地lambda表达式
         * 事实上，可以省略这里的lambda参数的类型声明，编译器可以从列表的类属性推测出来。
         *
         * (3): lambda内部可以使用静态、非静态和局部变量，这称为lambda内的变量捕获。
         *
         * (4): Lambda表达式在Java中又称为闭包或匿名函数，所以如果有同事把它叫闭包的时候，不用惊讶。
         *
         * (5): Lambda方法在编译器内部被翻译成私有方法，并派发 invokedynamic 字节码指令来进行调用。可以使用JDK中的 javap
         * 工具来反编译class文件。使用 javap -p 或 javap -c -v 命令来看一看lambda表达式生成的字节码。大致应该长这样：
         * private static java.lang.Object lambda$0(java.lang.String);
         *
         * (6): lambda表达式有个限制，那就是只能引用 final 或 final 局部变量，这就是说不能在lambda内部修改定义在域外的变量。
         */
    }
    static void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(condition).forEach(x -> System.out.println(x + " "));
    }
}
