package day4;

import java.util.TreeSet;

/**
 * Person 实现了 Comparable 重写了compareTo方法,并且,每次比较的时候会打印.这样
 * 我们就能清楚地看到比较了几次
 * @author weicong
 * @date 2018/3/20 0020
 */
public class SetTest1 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new Person("aa", 20, "男"));
        System.out.println();
        ts.add(new Person("bb", 18, "女"));
        System.out.println();
        ts.add(new Person("cc", 17, "男"));
        System.out.println();
        ts.add(new Person("dd", 17, "女"));
        System.out.println();
        ts.add(new Person("dd", 15, "女"));
        System.out.println();
        ts.add(new Person("dd", 15, "女"));
        System.out.println();


        System.out.println(ts);
        System.out.println(ts.size()); // 5

    }
}

class Person implements Comparable {
    private String name;
    private int age;
    private String gender;

    public Person() {

    }

    public Person(String name, int age, String gender) {

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age * 37;
    }

    public boolean equals(Object obj) {
        System.err.println(this + "equals :" + obj);
        if (!(obj instanceof Person)) {
            return false;
        }
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;

    }

    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", gender=" + gender
                + "]";
    }

    @Override
    public int compareTo(Object obj) {

        Person p = (Person) obj;
        System.out.println(this+" compareTo:"+p);
        if (this.age > p.age) {
            return 1;
        }
        if (this.age < p.age) {
            return -1;
        }
        return this.name.compareTo(p.name);
    }

}
