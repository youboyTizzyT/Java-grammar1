package day6;

/**
 * 泛型 泛型类 不多解释了,看懂泛型方法也能看懂这个
 * @author weicong
 * @date 2018/3/26 0026
 */
public class GenericTest {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("菜鸟教程");

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }
}

/**
 * 定义一个泛型类box
 * @param <T>
 */
class Box<T> {
    private T t;
    public void add(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}