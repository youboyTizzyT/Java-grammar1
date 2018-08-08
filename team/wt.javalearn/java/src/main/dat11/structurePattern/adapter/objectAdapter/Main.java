package dat11.structurePattern.adapter.objectAdapter;

public class Main {
    public static void main(String[] args) {
        Targetable targetable=new Adapter();
        targetable.saySing();
        targetable.sing();
    }
}
