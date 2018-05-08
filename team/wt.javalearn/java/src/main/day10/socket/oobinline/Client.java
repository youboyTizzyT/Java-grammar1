package day10.socket.oobinline;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author weicong
 * @date 2018/5/8 0008
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 1234);
        socket.setOOBInline(true);
        OutputStream out = socket.getOutputStream();
        OutputStreamWriter outWriter = new OutputStreamWriter(out);
        // 向服务器发送字符"C"
        outWriter.write(67);
        outWriter.write("hello world");
        // 向服务器发送字符"A"
        socket.sendUrgentData(65);
        socket.sendUrgentData(322);
        // 向服务器发送字符"B"
        //16个0 00000001 01000010          //sendUrgentData只发送整型数的低字节  01000010是66
        outWriter.flush();
        socket.close();
    }
}
