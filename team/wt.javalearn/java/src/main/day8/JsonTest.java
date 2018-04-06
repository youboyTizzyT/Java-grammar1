package day8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Json 作为大部分前后端交互的消息格式,对于java的Json非常好使用,对于前后端交互消息拼接,非常容易.这里采用大阿里的fastjson
 * json有json格式和jsonArray的两种,熟练使用,对数据的操控.
 * @author weicong
 * @date 2018/4/3 0003
 */
public class JsonTest {
    public static void main(String[] args) {
        ArrayList<China> chinaArrayList=new ArrayList<>();
        China china=new China();
        china.setName("中国");
        List<Province> provinceList=new ArrayList<>();
        Province hei=new Province();
        hei.setName("黑龙江");
        City heiCity=new City();
        heiCity.setCity(new String[]{"哈尔滨","大庆"});
        hei.setCitys(heiCity);
        provinceList.add(hei);

        Province guang=new Province();
        guang.setName("广东");
        City guangCity=new City();
        guangCity.setCity(new String[]{"广州","深圳","珠海"});
        guang.setCitys(guangCity);
        provinceList.add(guang);
        china.setProvince(provinceList);
        chinaArrayList.add(china);


        String result2= JSON.toJSONString(chinaArrayList);
        System.out.println(result2);
        JSONArray arr=JSON.parseArray(result2);
        System.out.println(arr.get(0));
    }
}
