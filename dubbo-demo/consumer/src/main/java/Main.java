import org.sang.SayHello;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SayHello sayHello = (SayHello) ctx.getBean("sayHello");
        String s = sayHello.sayHello("张三");
        System.out.println(s);
    }
}
