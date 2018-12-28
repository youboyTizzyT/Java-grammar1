package cacheTest;


import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.MessageFormat;
import java.util.*;


/**
 * redis 缓存拦截
 * weicong
 * 2017/04/18
 * 15:50
 */
@Aspect
public class CacheProxy {
    private static RedisUtils redis = RedisFactory.getDef();
    private static String CACHE_NULL_STR = "=null==";
    private static boolean redisSwitch = true;
    private static Map<String,RedisUtils> redisMap=new HashMap<>();
    /**
     * redis
     *
     * @param cache
     */
    @Pointcut(value = "(execution(* cacheTest.EntryImpl.getEntry(..))", argNames = "cache")
    public void redisAdd(RedisCache cache) {
    }


    /**
     * 新增redis 缓存
     *
     * @param joinPoint
     * @param cache
     *
     * @return
     * @throws Throwable
     */
    @Around(value = "redisAdd(cache)", argNames = "joinPoint,cache")
    public Object aroundRedisAdd(ProceedingJoinPoint joinPoint, RedisCache cache) throws Throwable {
        System.out.println(2);
        if (!redisSwitch) {
            return joinPoint.proceed();
        }
        RedisUtils redisUtils;
        String cacheName = cache.cacheName();
        redisUtils=StringUtils.isNotEmpty(cacheName)&&redisMap.get(cacheName)!=null?redisMap.get(cacheName):redis;
        Object proceed = null;
        try {
            String cacheKey = null;
            Set<String> keyList = getRedisKeyList(cache.pattern(), true, joinPoint, cache, proceed,redisUtils).getPatternListKey();
            if (keyList.size() > 0) {
                cacheKey = keyList.iterator().next();
            }
            Object element = redisUtils.get(cacheKey);
            if (element instanceof String && element.toString().equals(CACHE_NULL_STR)) {
                return null;
            } else if (element != null && element != null) {
                return element;
            }
            proceed = joinPoint.proceed();
            CacheKeyEntity cacheKeyEntity = getRedisKeyList(false, true, joinPoint, cache, proceed,redisUtils);
            Set<String> newKeyList = cacheKeyEntity.getPatternListKey();
            if (newKeyList.size() > 0) {
                cacheKey = newKeyList.iterator().next();
            }
            if(cacheKey==null)cacheKey="";
            if (cache.exir() == -1) {
                redisUtils.set(cacheKey, proceed == null ? CACHE_NULL_STR : proceed);
            } else {
                redisUtils.set(cacheKey, proceed == null ? CACHE_NULL_STR : proceed, proceed == null ? 11111: cache.exir());
            }

        } catch (Throwable e) {
            System.out.println(MessageFormat.format("redis add cache error class:[{0}] function:[{1}] params:{2}"
                    , joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
            try {
                return joinPoint.proceed();
            } catch (Throwable ex) {
                System.out.println(MessageFormat.format("DAO handler run add cache error class:[{0}] function:[{1}] params:{2}"
                        , joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
                throw ex;
            }
        }
        return proceed;
    }

    /**
     * 删除redis 缓存
     *
     * @param joinPoint
     * @param cache
     *
     * @throws Throwable
     */
    @Around(value = "redisDelete(cache)", argNames = "joinPoint,cache")
    public Object aroundRedisDelete(ProceedingJoinPoint joinPoint, RedisCache cache) throws Throwable {
        if (!redisSwitch) {
            return joinPoint.proceed();
        }
        RedisUtils redisUtils;
        String cacheName = cache.cacheName();
        redisUtils=StringUtils.isNotEmpty(cacheName)&&redisMap.get(cacheName)!=null?redisMap.get(cacheName):redis;
        Object proceed = null;
        try {
            Set<String> keyList = getRedisKeyList(cache.pattern(), true, joinPoint, cache, proceed,redisUtils).getPatternListKey();
            for (String delkey : keyList) {
                redisUtils.del(delkey);
            }
        } catch (Throwable e) {
            System.out.println(MessageFormat.format("redis cache delete cache error class:[{0}] function:[{1}] params:{2}",
                    joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
        }
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable ex) {
            System.out.println(MessageFormat.format("DAO handler run delete cache error class:[{0}] function:[{1}] params:{2}"
                    , joinPoint.getTarget().getClass(), joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs())));
            throw ex;
        }
        return proceed;
    }
    /**
     * 获取 cacheKey
     *
     * @param joinPoint
     * @param cache
     *
     * @return
     * @throws Exception
     */
    public CacheKeyEntity getRedisCacheKey(JoinPoint joinPoint, RedisCache cache, Object proceed) throws Exception {
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        MethodSignature signature = (MethodSignature) staticPart.getSignature();
        String returnEntity;
        ParameterizedType type = (ParameterizedType) joinPoint.getTarget().getClass().getGenericSuperclass();
        if (type != null && type.getActualTypeArguments() != null && StringUtils.isEmpty(cache.entity())) {
            returnEntity = type.getActualTypeArguments()[0].toString();
        } else {
            returnEntity = cache.entity();
        }
        if (returnEntity.indexOf("class ") != -1) returnEntity = returnEntity.substring(6);
        CacheKeyEntity cacheKeyEntity = new CacheKeyEntity();
        cacheKeyEntity.setPackageName(returnEntity);
        List<String> key = Arrays.asList(cache.key());
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        Map<String, Object> keys = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < parameterNames.length; j++) {
                String itemKey = key.get(i);
                String itemParam = parameterNames[j];
                if (itemKey.equals(itemParam)) {
                    keys.put(itemKey, args[j]);
                } else if (itemKey.indexOf(".") != -1 && itemKey.substring(0, itemKey.indexOf(".")).equals(itemParam)) {
                    Object arg = args[j];
                    String[] splitKey = itemKey.split("\\.");
                    for (int k = 1; k < splitKey.length; k++) {
                        String methodStr = splitKey[k].substring(0, 1).toUpperCase() + splitKey[k].substring(1);
                        Method method = arg.getClass().getMethod("get" + methodStr);
                        arg = method.invoke(arg);
                    }
                    if (arg != null) keys.put(itemKey.substring(itemKey.indexOf(".") + 1), arg);
                } else if (itemKey.equals("return") && proceed != null) {
                    keys.put(proceed.toString(), "=!null!==");
                } else if (itemKey.indexOf("return.") != -1 && proceed != null) {
                    String[] splitKey = itemKey.split("\\.");
                    Object retkey = null;
                    for (int k = 1; k < splitKey.length; k++) {
                        String methodStr = splitKey[k].substring(0, 1).toUpperCase() + splitKey[k].substring(1);
                        Method method = proceed.getClass().getMethod("get" + methodStr);
                        retkey = method.invoke(proceed);
                    }
                    if (retkey != null) keys.put(itemKey.substring(7), retkey);
                }

            }
        }
        cacheKeyEntity.setKeys(keys);
        return cacheKeyEntity;
    }


    public CacheKeyEntity getRedisKeyList(boolean pattern, boolean packageName, ProceedingJoinPoint joinPoint, RedisCache cache, Object proceed,RedisUtils redisUtils) throws Exception {
        Set<String> patternListKey = new HashSet<>();
        CacheKeyEntity cacheKeyEntity = getRedisCacheKey(joinPoint, cache, proceed);
        cacheKeyEntity.setJoin("|");
        cacheKeyEntity.setEntityJoin(":");
        Map<String, Object> keys = cacheKeyEntity.getKeys();
        String newKey = packageName ? cacheKeyEntity.getPackageName() + cacheKeyEntity.getJoin() : "";
        Integer total = 0;
        for (String del : keys.keySet()) {
            total++;
            Object o = keys.get(del);
            if (o == null) throw new Exception("key is null");
            if (o.toString().equals("=!null!==")) {
                newKey += del + cacheKeyEntity.getJoin();
            } else {
                newKey += del + cacheKeyEntity.getEntityJoin() + o.toString() + cacheKeyEntity.getJoin();
            }
            if (pattern) {
                patternListKey.addAll(redisUtils.getPatternListKey(newKey));
            } else if (total == keys.size()) {
                patternListKey.add(newKey);
            }
        }
        cacheKeyEntity.setPatternListKey(patternListKey);
        return cacheKeyEntity;
    }
}
