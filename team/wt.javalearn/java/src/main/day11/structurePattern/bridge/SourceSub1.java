package day11.structurePattern.bridge;

public class SourceSub1 implements Sourceable{
    @Override
    public void method() {
        System.out.println(111);
    }
}
