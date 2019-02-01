package day13.first;


/**
 * 苹果实体类
 *
 * @Author weicong
 * @Date 2019 2019/2/1 4:34 PM
 * @Version 1.0
 * @Description TODO
 */
public class Apple {

    @FruitName(name = "苹果")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
