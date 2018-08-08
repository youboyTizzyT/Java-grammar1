package dat11.designPattern.factoryMethodPattern;

public class People {
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    public void relax(){
        room.relax();
    }
}
