package day11.behavioralPattern.mediator;

public class CollegaueB extends Colleague{
    public CollegaueB(String name, Mediator mediator) {
        super(name, mediator);
    }
    public void getMessage(String message){
         System.out.println("同事B"+name+"获得信息"+message);
     }
    //同事A与中介者通信
    public void contact(String message){
        mediator.contact(message, this);
    }
}
