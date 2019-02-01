package day13.first;


import java.lang.annotation.*;

/**
 * 水果名字
 *
 * @Author weicong
 * @Date 2019 2019/2/1 4:32 PM
 * @Version 1.0
 * @Description TODO
 */
//1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
//2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
//3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitName {
    // default意思是默认值
    String name() default "未命名";
}
