package day10.http.httpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.*;
import java.net.InetSocketAddress;

/**
 * @author weicong
 * @date 2018/4/19 0019
 */
public class MyHttpServer {
    public static void main(String[] args) throws IOException {
        httpServerService();
    }
    public static void httpServerService() throws IOException {
        HttpServerProvider provider=HttpServerProvider.provider();
        // 监听6666 端口,同事能接受100个请求
        HttpServer httpServer=provider.createHttpServer(new InetSocketAddress(6666),100);
        httpServer.createContext("/myApp",new MyHttpHandler());
        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("service started!");
    }
    static class MyHttpHandler implements HttpHandler{

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String responseMsg="ok";
            InputStream inputStream=httpExchange.getRequestBody();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String temp;
            while ((temp=bufferedReader.readLine())!=null){
                System.out.println("client request:"+temp);
            }
            httpExchange.sendResponseHeaders(200,responseMsg.length());
            OutputStream out=httpExchange.getResponseBody();
            out.write(responseMsg.getBytes());
            out.flush();
            httpExchange.close();
            out.close();
            bufferedReader.close();
        }
    }

}
