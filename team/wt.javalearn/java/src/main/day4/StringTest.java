package day4;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * String,StringBuffer
 * @author weicong
 * @date 2018/3/20 0020
 */
public class StringTest {
    public static void main(String args[]){
        /* String没有特殊讲过,但是我相信也不陌生 这里说一下String类有什么特点
         * String类为final类,前面讲过了,final类是无法被继承的,
         * 也就是说String的字符串一旦创建了String,那么他的值也就无法改变了
         * 如果我们想改变String类的值.我们就应该选择StringBuffer或者StringBuilder类
         */
        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);
        System.out.println( helloString );
        // String 有一个方法length,他是判断字符串的长度.
        int len=helloString.length();
        System.out.println(len);
        // 如果我们想连接字符串的话,java也给出了人性化的打代码方式 concat
        System.out.println("我的名字是:".concat(helloString));
        // 但是我们更常用的应该为+
        System.out.println("我的名字是:"+helloString);
        /*
         * 正因为我们的String类为final类,此时,我们使用连接字符串的时候
         * 比如: "我的名字是:"+"啦啦啦"
         * 其实内存中存在3个对象.我的名字是:和啦啦啦和我的名字是:啦啦拉
         */
        // String类支持的方法,一个一个来,更多详细,请在idea中按住ctrl点String类就可以,当然你也可以自己去jdk包下自己寻找
        // compareTo 返回值: 0 为完全一样 其他为不一样 作用:比较两个字符串是否相同 一般情况,我们也经常采用equals比较
        String a="111";
        System.out.println(a.compareTo("1"));
        // compareToIgnoreCase(String str) 返回值: 0 为不区分大小写是一样的 其他为不一样
        String b="11A";
        System.out.println(b.compareToIgnoreCase("1a"));
        //  concat(String str) 将指定字符串连接到此字符串的结尾。
        String c="123";
        System.out.println(c.concat("2"));
        // 	contentEquals(StringBuffer sb) 返回值	boolean 当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真
        StringBuffer sb=new StringBuffer("123123");
        String d="123123";
        System.out.println(d.contentEquals(sb));
        // equals(Object anObject) 返回值 boolean  将此字符串与指定的对象比较。
        // 注意 : 写equals时切记"123".equals(e)这样写而不是e.equals("123") 否则容易发生空指针报错
        String e="123";
        System.out.println("123".equals(e));
        // endsWith(String suffix) 返回值 boolean 判断次字符串是否亿suffix结尾
        System.out.println("123".endsWith("3"));
        // indexOf(int ch) 返回值 int -1表示没有出现过 返回指定字符在此字符串中第一次出现处的索引。
        System.out.println("123".indexOf("3"));
        /*
         * 当然String的方法还有很多,在此就不一一罗列了,想看的可以去查看一下源代码.
         */
        /*
         * StringBuffer类和StringBuilder类
         * 面试的时候经常被问到 String和StringBuffer和StringBuilder类有什么区别呀?
         * 这时候很多蒙了,或者问,这三个哪一个快呀.接下来,我们就来看看
         */
        // StringBuffer 这样来连接我们的字符串
        StringBuffer sBuffer = new StringBuffer("我的名字叫做：");
        sBuffer.append("lu");
        sBuffer.append("ben");
        sBuffer.append("wei");
        System.out.println(sBuffer);
        // StringBuffer reverse方法,将此字符序列用其反转形式取代
        System.out.println(sBuffer.reverse());// 输出: iewnebul：做叫字名的我
        // StringBuffer delete(int start,int end) 移除此序列的子字符串中的字符。
        sBuffer.delete(0,2);
        System.out.println(sBuffer);// 输出: wnebul：做叫字名的我
        // StringBuffer insert(int offset,int i) 把第二个参数,插入到第2个位置后面
        sBuffer.insert(2,"123");
        System.out.println(sBuffer);
        //StringBuffer replace(int start,int end,String str) 从开始到结尾中替换成str
        sBuffer.replace(2,5,"123123");
        System.out.println(sBuffer);
        /*
         * 三者区别
         * String 字符串常量
         * StringBuffer 字符串变量（线程安全）
         * StringBuilder 字符串变量（非线程安全）
         *
         * String 类型和 StringBuffer 类型的主要性能区别其实在于 String 是不可变的对象,
         * 因此在每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，
         * 然后将指针指向新的 String 对象，所以经常改变内容的字符串最好不要用 String ，
         * 因为每次生成对象都会对系统性能产生影响，特别当内存中无引用对象多了以后，
         * JVM 的 GC 就会开始工作，那速度是一定会相当慢的。
         */
        String S1 = "This is only a" + " simple" + " test";
        StringBuffer Sb = new StringBuffer("This is only a").append(" simple").append("test");
        /*
         * 其实这时候的运行速度,String太快了.其实,在jvm眼里String S1 = "This is only a" + " simple" + " test";
         * 就相当于String S1 = "This is only a simple test";
         * Java.lang.StringBuffer线程安全的可变字符序列,一个类似于 String 的字符串缓冲区
         * StringBuffer 上的主要操作是 append 和 insert 方法 可重载这些方法 以接受任何数据类型的添加
         */
        // StringBuilder 在这里不多介绍,api和StringBuffer一样
    }
}
