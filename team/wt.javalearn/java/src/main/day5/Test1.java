package day5;

/**
 * 多态的面试题
 * @author weicong
 * @date 2018/3/26 0026
 */
public class Test1 {
    public static void main(String[] args) {
        // 都是new的无参构造方法
        // 第一种情况，输出结果的顺序
        // 说明：没有使用多态，父类的引用指向子类的对象，还是会执行父类的无参构造方法。
        Son f = new Son();
        System.out.println(f.x);

        // 第二种情况，输出结果的顺序
        // 说明：使用了多态，注意这里输出的是1。
        Father f1 = new Son();
        System.out.println(f1.x);

        //使用new的有参构造方法
        Son f2 = new Son("hello");
        System.out.println(f2.x);
        /*
        father
        son:hello
        2
        */
        Father f3 = new Son("hello");
        System.out.println(f3.x);
        /*
        father
        son:hello
        1
        */
        /**
         *总结：只要是new子类，无论是调用子类的有参构造还是无参构造都会执行父类的无参构造。当
         * 子类和父类有同一个变量名字的变量时，如果是使用了多态则调用的是父类的变量。否则调用的是子类的变量。
         * 补充：执行顺序，静态块＞构造语句块＞函数块
         */
    }

}

class Father {
    int x = 1;

    public Father() {
        System.out.println("father");
    }

    public Father(String s) {
        System.out.println("father:" + s);
    }
}


class Son extends Father {
    int x = 2;

    public Son() {
        System.out.println("son");
    }

    public Son(String s) {
        System.out.println("son:" + s);
    }
}
