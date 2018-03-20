package day4;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 让容器自身具备比较性，自定义比较器。
 * @author weicong
 * @date 2018/3/20 0020
 */
public class SetTest2 {
    public static void main(String[] args) {
        TreeSet<Book> ts = new TreeSet<Book>(new MyComparator());
        ts.add(new Book("think in java", 100));
        System.out.println();
        ts.add(new Book("java 核心技术", 75));
        System.out.println();
        ts.add(new Book("现代操作系统", 50));
        System.out.println();
        ts.add(new Book("java就业教程", 35));
        System.out.println();
        ts.add(new Book("think in java", 100));
        System.out.println();
        ts.add(new Book("ccc in java", 100));

        System.out.println(ts);
    }
}

class MyComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;
        System.out.println(b1+" comparator "+b2);
        if (b1.getPrice() > b2.getPrice()) {
            return 1;
        }
        if (b1.getPrice() < b2.getPrice()) {
            return -1;
        }
        return b1.getName().compareTo(b2.getName());
    }

}

class Book {
    private String name;
    private double price;

    public Book() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, double price) {

        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [name=" + name + ", price=" + price + "]";
    }

}
