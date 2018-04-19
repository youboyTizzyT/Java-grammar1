package day10.http;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author weicong
 * @date 2018/4/18 0018
 */
public class UrlEnDecoder {
    public static void main(String[] args)
            throws Exception {
        // 将application/x-www-form-urlencoded字符串
        // 转换成普通字符串
        // 其中的字符串直接从图17.3所示窗口复制过来
        String keyWord = URLDecoder.decode(
                "%B9%FE%B9%FE%B9%FE", "GBK");
        System.out.println(keyWord);
        // 将普通字符串转换成
        // application/x-www-form-urlencoded字符串
        String urlStr = URLEncoder.encode(
                "哈哈哈", "GBK");
        System.out.println(urlStr);
    }
}
