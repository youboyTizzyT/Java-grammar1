package day6.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化时间
 * @author weicong
 * @date 2018/3/27 0027
 */
public class TimeTest1 {
    public static void main(String[] args){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd    HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(date));
    }
}
