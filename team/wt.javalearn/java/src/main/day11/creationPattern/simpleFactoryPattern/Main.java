package day11.creationPattern.simpleFactoryPattern;

public class Main {
    public static void main(String[] args) {
        new People(Factory.createRoom(1));
    }
}
