package day3.modifier;

/**
 * @author weicong
 * @date 2018/3/20 0020
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//定义一个需要序列化的类

class People implements Serializable{
    String name; //姓名
    transient Integer age; //年龄
    public People(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名 = "+name+" ,年龄 = "+age;
    }

}

public class TransientTest1 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        People a = new People("李雷",30);
        System.out.println(a); //打印对象的值
        // 根据文件路径去写入文件,down代码的童鞋可以自己更改.保证写入和读的文件路径一致就行
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./team/wt.javalearn/java/src/main/day3/modifier/people.txt"));
        os.writeObject(a);//写入文件(序列化)
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("./team/wt.javalearn/java/src/main/day3/modifier/people.txt"));
        a = (People)is.readObject();//将文件数据转换为对象（反序列化）
        System.out.println(a); // 年龄 数据未定义
        is.close();
    }
}
