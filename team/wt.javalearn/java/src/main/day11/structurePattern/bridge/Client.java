package day11.structurePattern.bridge;

public class Client {
    public static void main(String[] args) {
        Bridge bridge=new MyBridge();
        Sourceable source1=new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        Sourceable source2=new SourceSub2();
        bridge.setSource(source2);
        bridge.method();
        /**
         * 这样，就通过对Bridge类的调用，实现了对接口Sourceable的实现类SourceSub1和SourceSub2的调用。接下来我再画个图，大家
         * 就应该明白了，因为这个图是我们JDBC连接的原理，有数据库学习基础的，一结合就都懂了。
         */
    }
}
