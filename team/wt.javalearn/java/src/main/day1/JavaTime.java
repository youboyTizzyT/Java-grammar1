package day1;

import redis.clients.jedis.Jedis;

/**
 * 进行测试代码运行时间.
 * 可以封装成代理模式.也可以进行Spring使用aop实现.
 * 计算函数运行纳秒的时间,超过500wns的函数是不可以的,就应该优化函数.优化一切能优化的
 * @author weicong
 * @date 2018/3/28 0028
 */
public class JavaTime {
    public static void main(String[] args) {
        int a=0;
        long startTime=System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            a+=i;
        }
        //获取结束时间
        long endTime=System.nanoTime();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
    }
}
