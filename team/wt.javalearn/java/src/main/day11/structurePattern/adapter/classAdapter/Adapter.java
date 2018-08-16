package day11.structurePattern.adapter.classAdapter;

public class Adapter  implements Targetable {
    private Source source;
    public Adapter(Source source){
        this.source=source;
    }
    @Override
    public void sing() {
        source.sing();
    }

    @Override
    public void saySing() {
        System.out.println("kris5 can saySing!");
    }
}
