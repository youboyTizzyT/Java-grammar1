package day11.structurePattern.adapter.objectAdapter;

public class Adapter extends Source implements Targetable {
    @Override
    public void saySing() {
        System.out.println("kris5 can saySing!");
    }
}
