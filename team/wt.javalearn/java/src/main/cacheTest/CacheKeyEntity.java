package cacheTest;

import java.util.Map;
import java.util.Set;

/**
 * @description: 缓存实体
 * @author: weicong
 * @date: 2017/05/19 17:22
 */
public class CacheKeyEntity {
    private String packageName;
    private String join;
    private Map<String,Object> keys;
    private String entityJoin;
    private Set<String> patternListKey;
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    public Map<String, Object> getKeys() {
        return keys;
    }

    public void setKeys(Map<String, Object> keys) {
        this.keys = keys;
    }

    public String getEntityJoin() {
        return entityJoin;
    }

    public void setEntityJoin(String entityJoin) {
        this.entityJoin = entityJoin;
    }

    public Set<String> getPatternListKey() {
        return patternListKey;
    }

    public void setPatternListKey(Set<String> patternListKey) {
        this.patternListKey = patternListKey;
    }
}
