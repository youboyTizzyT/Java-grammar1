package dat11.designPattern.simpleFactoryPattern;

public class Main {
    public static void main(String[] args) {
        new People(Factory.createRoom(1));
    }
}
