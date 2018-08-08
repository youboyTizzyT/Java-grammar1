package dat11.creationPattern.factoryMethodPattern;

public class Main {
    public static void main(String[] args) {
        People people=new People();
        // 创建抽象工厂
        Factory factory=new ConcreteFactory();
        Room room=factory.createRoom(2);
        people.setRoom(room);
        people.relax();
    }
}
