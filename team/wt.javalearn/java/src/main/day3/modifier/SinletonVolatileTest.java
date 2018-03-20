package day3.modifier;

/**
 * 使用volatile类型实现单例模式,保证只存在一个类,volatile也成为内存屏障
 * 其实说白了,就是访问数据的时候再从内存中读取一次,但是volatile不能保证并发性
 * @author weicong
 * @date 2018/3/20 0020
 */
public class SinletonVolatileTest{
    private volatile static SinletonVolatileTest instance = null;
    private SinletonVolatileTest() {
    }

    public static SinletonVolatileTest getInstance() {
        if(instance==null) {
            synchronized (SinletonVolatileTest.class) {
                if(instance==null)
                    instance = new SinletonVolatileTest();
            }
        }
        return instance;
    }
}
