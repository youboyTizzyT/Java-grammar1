package day6;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符
 * @author weicong
 * @date 2018/3/26 0026
 */
public class GenericTest1 {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("icon");
        age.add(18);
        number.add(314);

//        getUperNumber(name);  会报错,因为String不是继承与Number
        getData(age);
        getData(number);

    }

    /**
     * 泛型通配符
     * @param data
     */
    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    /**
     * 当然,我们也可以限制?类型的范围
     * @param data
     */
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}
