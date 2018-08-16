package day11.creationPattern.factoryMethodPattern;

public class ConcreteFactory extends Factory{
    @Override
    Room createRoom(int arg) {
        if (arg==1){
            return new RoomC();
        }
        if (arg==2){
            return new RoomD();
        }
        return null;
    }
}
