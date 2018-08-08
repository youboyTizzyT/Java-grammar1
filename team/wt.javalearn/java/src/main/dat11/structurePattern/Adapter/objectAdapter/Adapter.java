package dat11.structurePattern.Adapter.objectAdapter;

public class Adapter extends Source implements Targetable {
    @Override
    public void saySing() {
        System.out.println("kris5 can saySing!");
    }
}
