package cacheTest;

public class EntryImpl {

    @RedisCache(key = "appkey")
    public Entry getEntry(String appkey){
        Entry entry=new Entry();
        entry.setAppkey(appkey);
        entry.setAge(12);
        entry.setName("weicong");
        System.out.println(1);
        return entry;
    }
}
