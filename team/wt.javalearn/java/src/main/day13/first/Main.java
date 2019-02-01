package day13.first;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 测试类
 *
 * @Author weicong
 * @Date 2019 2019/2/1 4:35 PM
 * @Version 1.0
 * @Description TODO
 */
public class Main {
    public static void main(String[] args) {
        Apple apple=new Apple();
        // 这里打印出来是null 因为注解并不是字段的值，这里我们需要使用反射调用获取注解
        System.out.println(apple.getName());

        Class clazz=apple.getClass();
        try {
            Field field=clazz.getDeclaredField("name");
            Annotation[] fruitName=field.getAnnotations();
            for (int i = 0; i < fruitName.length; i++) {
                System.out.println(fruitName[i]);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
