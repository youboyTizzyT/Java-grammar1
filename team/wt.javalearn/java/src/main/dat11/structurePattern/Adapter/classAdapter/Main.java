package dat11.structurePattern.Adapter.classAdapter;

public class Main {
    public static void main(String[] args) {
        Source source=new Source();
        Targetable targetable=new Adapter(source);
        targetable.saySing();
        targetable.sing();
    }
}
