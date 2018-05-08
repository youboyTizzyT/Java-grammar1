package day10.http.httpserver;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author weicong
 * @date 2018/5/8 0008
 */
public class MyClientTest {
    public static void main(String[] args) {
        // 手动创建线程池
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService exec =  new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                namedThreadFactory);
        // 测试并发对MyHttpServer的影响   设置一共20个任务将会提交到线程池
        int num=20;
        for (int i = 0; i < num; i++) {
            Runnable run = () -> {
                try {
                    startWork();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            // 提交任务
            exec.execute(run);
        }
        exec.shutdown();// 关闭线程池
    }
    private static void startWork() throws IOException {
        URL url = new URL("http://127.0.0.1:6666/myApp");
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setDoOutput(true);
        urlConn.setDoInput(true);
        urlConn.setRequestMethod("POST");
        // 测试内容包
        String teststr = "this is a test message";
        OutputStream out = urlConn.getOutputStream();
        out.write(teststr.getBytes());
        out.flush();
        while (urlConn.getContentLength() != -1) {
            if (urlConn.getResponseCode() == 200) {
                InputStream in = urlConn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String temp;
                while ((temp = reader.readLine()) != null) {
                    // 打印收到的信息
                    System.err.println("server response:" + temp);
                }
                reader.close();
                in.close();
                urlConn.disconnect();
            }
        }
    }
}
