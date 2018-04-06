package day5.extend;

/**
 * 继承
 * @author weicong
 * @date 2018/3/26 0026
 */
public class Extend {
    public static void main(String[] args) {
        Penguin penguin=new Penguin("卢本伟",1);
        penguin.introduction();
        penguin.sleep();
    }
}
class Animal{
    private String name;
    private int id;
    public Animal(String myName, int myid) {
        name = myName;
        id = myid;
    }
    public void eat(){
        System.out.println(name+"正在吃  父类");
    }
    public void sleep(){
        System.out.println(name+"正在睡  父类");
    }
    public void introduction() {
        System.out.println("大家好！我是"+ id + "号" + name + ".  父类");
    }
}

/**
 * 从这两段代码可以看出来，代码存在重复了，导致后果就是代码量大且臃肿，而且维护性不高(维护性主要是后期需要修改的时候，就
 * 需要修改很多的代码，容易出错)，所以要从根本上解决这两段代码的问题，就需要继承，将两段代码中相同的部分提取出来组成 一个
 * 父类
 */
class Penguin extends Animal{

    private String name;
    private int id;

    public Penguin(String myName, int myid) {
        super(myName, myid);
        this.id=myid;
        this.name=myName;
    }

    public void eat(){
        System.out.println(name+"正在吃  企鹅类");
    }
    public void sleep(){
        System.out.println(name+"正在睡  企鹅类");
    }
    public void introduction() {
        // super 是调用父类的方法
        super.introduction();
        // this 是调用本类的方法
        this.sleep();
        System.out.println("大家好！我是"         + id + "号" + name + ".  企鹅类");
    }
}

/**
 * 子类不能继承父类的构造器（构造方法或者构造函数），但是父类的构造器带有参数的，则必须在子类的构造器中显式地通过super关
 * 键字调用父类的构造器并配以适当的参数列表。
 * 如果父类有无参构造器，则在子类的构造器中用super调的用父类构造器不是必须，如果没有使用super关键字，系统会自动调用父类
 * 的无参构造器。
 */
 class Mouse extends Animal{
    private String name;
    private int id;
    //这个Animal类就可以作为一个父类，然后企鹅类和老鼠类继承这个类之后，就具有父类当中的属性和方法，子类就不会存在重复的
    // 代码，维护性也提高，代码也更加简洁，提高代码的复用性（复用性主要是可以多次使用，不用再多次写同样的代码） 继承之后
    // 的代码：
    public Mouse(String myName, int  myid) {
        super(myName,myid);
    }
    public void eat(){
        System.out.println(name+"正在吃  老鼠类");
    }
    public void sleep(){
        System.out.println(name+"正在睡  老鼠类");
    }
    public void introduction() {
        System.out.println("大家好！我是"         + id + "号" + name + ".  老鼠类");
    }
}