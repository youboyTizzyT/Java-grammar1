package cacheTest;

/**
 * @description: redis工厂
 * @author: chenhm
 * @date: 2017/06/29 16:28
 */
public class RedisFactory {
    private static final RedisUtils defRedis=new RedisUtils("redis.properties");
    private static final RedisUtils deviceRedis=new RedisUtils("newDeviceRedis.properties");
    private static final RedisUtils activeRedis=new RedisUtils("aliveDeviceRedis.properties");
    private static final RedisUtils browserRedis=new RedisUtils("browserDeviceRedis.properties");

    private RedisFactory(){
    }
    //默认reids
    public static RedisUtils getDef(){
        return defRedis;
    }
    //新增设备reids
    public static RedisUtils getDevice(){
        return deviceRedis;
    }

    //userAgent设备识别缓存
    public static RedisUtils getBrowserRedis(){
        return browserRedis;
    }
    //活跃设备reids
    public static RedisUtils getActive(){
        return activeRedis;
    }
}
