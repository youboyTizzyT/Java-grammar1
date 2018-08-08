package dat11.structurePattern.bridge;

public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}
