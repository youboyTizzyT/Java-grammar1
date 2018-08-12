package dat11.behavioralPattern.observer;

public class User implements Observer {
    public User(String name) {
        this.name = name;
    }
    private String name;
    private String massage;
    @Override
    public void update(String massage) {
        this.massage=massage;
        read();
    }

    public void read(){
        System.out.println(name+"收到消息："+massage);
    }
}
