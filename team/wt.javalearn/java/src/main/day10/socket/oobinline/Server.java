package day10.socket.oobinline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weicong
 * @date 2018/5/8 0008
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(1234);
        System.out.println("服务器已经启动,端口号:1234");
        while (true){
            Socket s=ss.accept();
            s.setOOBInline(true);
            // 获取输入流
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            // 释放资源
            s.close();
            br.close();
        }
    }
}
