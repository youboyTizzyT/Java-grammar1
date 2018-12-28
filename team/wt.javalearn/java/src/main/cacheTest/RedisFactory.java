package cacheTest;

/**
 * @description: redis工厂
 * @author: chenhm
 * @date: 2017/06/29 16:28
 */
public class RedisFactory {
    private static final RedisUtils defRedis=new RedisUtils("redis.properties");
    private RedisFactory(){
    }
    //默认reids
    public static RedisUtils getDef(){
        return defRedis;
    }
   }
