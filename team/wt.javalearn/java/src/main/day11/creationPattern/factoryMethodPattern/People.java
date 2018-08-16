package day11.creationPattern.factoryMethodPattern;

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
