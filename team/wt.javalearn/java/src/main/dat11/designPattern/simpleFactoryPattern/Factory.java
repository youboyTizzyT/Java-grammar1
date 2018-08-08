package dat11.designPattern.simpleFactoryPattern;

public class Factory {
    public static Room createRoom(int arg){
        if (arg==1){
            return new RoomA();
        }
        if (arg==2){
            return new RoomB();
        }
        return null;
    }
}
