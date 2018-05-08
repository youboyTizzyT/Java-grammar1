package day10.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author weicong
 * @date 2018/5/8 0008
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // 创建一个Socket 访问127.0.0.1 的 30000
        Socket socket=new Socket("127.0.0.1",30000);
        socket.setSoLinger(true,60);
        // 获取本地执行Socket连接的端口号
        System.out.println("客户端本地端口号"+socket.getLocalPort());
        // 打开输出流,并且将发送给ServerSocket的消息放入输入流,并flush过去
        PrintStream ps=new PrintStream(socket.getOutputStream());
        ps.println("谢谢祝福,热爱工作!");
        ps.flush();
        // 打开输入流,接受服务端过来的消息,并进行操作
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line=br.readLine();
        System.out.println("来自服务器的消息:"+line);
        // 关闭输入输出流和socket
        ps.close();
        br.close();
        socket.close();
    }
}
