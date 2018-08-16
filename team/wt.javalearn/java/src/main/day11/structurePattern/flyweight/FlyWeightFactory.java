package day11.structurePattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FlyWeightFactory {
    Map<String,FlyWeight> pool=new ConcurrentHashMap<>();
    public FlyWeight getFlyWeight(String name){
        if (pool.get(name)!=null){
            return pool.remove(name);
        }else {
            return new FlyWeight(name);
        }
    }
    public boolean returnFlyWeight(FlyWeight flyWeight){
        if (pool.get(flyWeight.getName())!=null){
            return false;
        }else {
            pool.put(flyWeight.getName(),flyWeight);
            return true;
        }
    }
}
