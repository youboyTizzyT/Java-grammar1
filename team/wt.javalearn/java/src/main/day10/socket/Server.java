package day10.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weicong
 * @date 2018/5/8 0008
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket 设置监听30000端口号
        ServerSocket ss=new ServerSocket(30000);
        // 死循环
         while (true)
        {
            System.out.println("等待客户端连接服务器");
            // 使ServerSocket进行等待客户端进行连接,如果有连接将会分配给Socket s工作.然后工作完了,继续等待.
            Socket s=ss.accept();
            System.out.println("客户端使用的端口号为"+s.getPort());
            PrintStream ps=new PrintStream(s.getOutputStream());
            // 给客户端穿的消息放入输出流里面
            ps.println("您好, 收到了服务器的加班快乐");
            // flush给客户端,如果不flush 不一定会发送给客户端,需要设置
            ps.flush();
            // 使用BufferedReader读取客户端传过来的消息
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            // 进行操作
            String line=br.readLine();
            System.out.println("客户端的消息为:"+line);
            // 关闭输入输出流,关闭socket 毕竟是BIO 无法同时接受两个客户端
            br.close();
            ps.close();
            s.close();
        }
    }
}
