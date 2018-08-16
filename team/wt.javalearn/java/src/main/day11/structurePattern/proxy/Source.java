package day11.structurePattern.proxy;

public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
