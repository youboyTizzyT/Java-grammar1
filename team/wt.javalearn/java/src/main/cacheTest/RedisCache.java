package cacheTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * redisCache 注解
 * weicong
 * 2017/04/18
 * 20:09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RedisCache {
    String cacheName() default "";
    String entity() default "";
    String [] key();
    boolean pattern() default false;
    int exir() default 1200;
}
