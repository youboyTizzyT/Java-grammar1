package cacheTest;

import com.mob.jedis.HyperLogLog;
import com.mob.jedis.Redis;
import com.mob.jedis.RedisFactory;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Redis进行序列化缓存
 *
 * @author weicong
 */

public class RedisUtils {
    private Redis redis;
    private static HashMap<String, Redis> CACHE = new HashMap<>();
    /**
     * 无参构造走有参构造
     */
    public RedisUtils() {
        this("redis.properties");
    }

    public static void main(String[] args) {
        RedisUtils redisUtils = new RedisUtils("redis.properties");
        redisUtils.setStr("111","1121");
        System.out.println(redisUtils.getStr("111"));
    }

    /**
     * 构造器，
     * @param property
     */
    public RedisUtils(String property) {
        if (StringUtils.isNotEmpty(property)) {
            this.redis = com.mob.jedis.RedisFactory.getInstance(property).getRedis();
            redis.put(property,property);
        } else {
            this.redis = RedisFactory.getInstance().getRedis();
        }
    }

    private static final int expire = 10000;

    /**
     * set Object
     */
    public void set(String key, Object object) {
        redis.put(key.getBytes(), SerializeUtil.serialize(object));
    }

    public Redis getRedis() {
        return redis;
    }

    public void setRedis(Redis redis) {
        this.redis = redis;
    }

    /**
     * set valid time Object
     */
    public void set(String key, Object object, int expire) {
        redis.put(key.getBytes(), SerializeUtil.serialize(object), expire);
    }

    /**
     * get Object
     */
    public Object get(String key) {
        if (key == null) return null;
        byte[] value = redis.get(key.getBytes());
        return value != null ? SerializeUtil.unserialize(value) : null;
    }

    public String getPatternKey(String key) {
        Set<String> keys = redis.keys("*" + key + "*");
        Iterator<String> iterator = keys.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    public Set<String> getPatternListKey(String key) {
        Set<String> keys = redis.keys("*" + key + "*");
        return keys;
    }

    public String getStr(String key) {
        if (key == null) return null;
        return redis.get(key);
    }

    public void setStr(String key, String value, int expire) {
        redis.put(key, value, expire);
    }

    public void setStr(String key, String value) {
        redis.put(key, value);
    }

    /**
     * delete a key
     **/
    public boolean del(String key) {
        return redis.remove(key.getBytes()) > 0;
    }

    public boolean delStr(String key) {
        return redis.remove(key) > 0;
    }

    public Long add(String key) {
        return redis.increase(key);
    }

    public Set<String> keys(String pattern) {
        return redis.keys(pattern);
    }

    public Long hyperLogAdd(String key, String content, Integer exit) {
        HyperLogLog<String> hyperLogLog = redis.getHyperLogLog(key);
        if (exit != null) hyperLogLog.expire(exit);
        return hyperLogLog.add(content);
    }
    public Long hyperLogSize(String key) {
        HyperLogLog<String> hyperLogLog = redis.getHyperLogLog(key);
        return hyperLogLog.size();
    }
}
