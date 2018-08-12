package dat11.behavioralPattern.mediator;

public class Main {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator=new ConcreteMediator();
        // 定义具体同事类
        ColleagueA colleagueA = new ColleagueA("张三", concreteMediator);
        CollegaueB colleagueB = new CollegaueB("李四", concreteMediator);
        // 中介者知晓每一个具体的Colleague类
        concreteMediator.setColleagueA(colleagueA);
        concreteMediator.setCollegaueB(colleagueB);


        colleagueA.contact("我是A，我要和同事B说说工作的事情");
        colleagueB.contact("我是B,我下午有时间,下午商量吧");
    }
}
