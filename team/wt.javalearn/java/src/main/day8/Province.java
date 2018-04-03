package day8;

/**
 * 省
 * @author weicong
 * @date 2018/4/3 0003
 */
public class Province {
    private City citys;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCitys() {
        return citys;
    }

    public void setCitys(City citys) {
        this.citys = citys;
    }

}
