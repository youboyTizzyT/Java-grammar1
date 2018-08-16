package day11.structurePattern.flyweight;

public class Client {
    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory=new FlyWeightFactory();
        FlyWeight A=flyWeightFactory.getFlyWeight("A");
        FlyWeight A2=flyWeightFactory.getFlyWeight("A");
        FlyWeight B=flyWeightFactory.getFlyWeight("B");
        FlyWeight C=flyWeightFactory.getFlyWeight("C");

        flyWeightFactory.returnFlyWeight(A);
        System.out.println(A.getName());
        /**
         * 节省性能
         */
    }
}
