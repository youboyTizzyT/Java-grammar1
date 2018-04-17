package day9;

import java.util.Optional;

/**
 * @author weicong
 * @date 2018/4/17 0017
 */
public class LambdaUtil {
    public static void main(String[] args) {
        /**
         * 我们可以用Optional类型来拜托所有类型null的检测
         */
        Optional.of(new Outer()).map(Outer::getNested)
                .map(Nested::getInner)
                .map(Inner::getFoo)
                .ifPresent(System.out::println);
        /**
         * 没有传统 null 检查那么高的性能。不过在大多数情况下不会有太大问题。
         */
    }
}
class Outer {
    Nested nested;
    Nested getNested() {
        return nested;
    }
}
class Nested {
    Inner inner;
    Inner getInner() {
        return inner;
    }
}
class Inner {
    String foo;
    String getFoo() {
        return foo;
    }
}
