package day11.creationPattern.singletonPattern;

/**
 * 使用枚举实现单例
 */
public enum  Singleton2 {
    uniqueInstance;
    public void otherMethods(){
        System.out.println("Something");
    }
}
