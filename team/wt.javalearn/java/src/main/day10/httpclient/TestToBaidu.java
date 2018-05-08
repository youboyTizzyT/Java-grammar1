package day10.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author weicong
 * @date 2018/5/8 0008
 */
public class TestToBaidu {
    public static void main(String[] args) throws Exception {
        String url = "http://www.baidu.com";
        String json ="{\"head\":{\"qn\":\"mydirectqueue\",\"id\":\"uuid\",\"ty\":1,\"h\":0,\"o\":0,\"s\":0}}";
        final CloseableHttpClient client = HttpClients.createDefault();
        final HttpPost httpPost;
        httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(json, "utf-8"));
        httpPost.setHeader("Content-type", "application/json");
        //执行请求操作，并拿到结果（同步阻塞）
        try {
            CloseableHttpResponse response = null;
            String body = "";

            response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            //释放链接
            response.close();
            System.out.println(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
