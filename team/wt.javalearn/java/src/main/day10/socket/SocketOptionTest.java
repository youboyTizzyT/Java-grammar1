package day10.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weicong
 * @date 2018/5/8 0008
 */
public class SocketOptionTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",30000);
        // Nagle算法:数据凑够了大小一起发,提高网络的利用率,避免1个自己的数据体无法占用满包的情况\
        // 将Nagle算法关闭了,客户端每次发送消息,无轮数据包大小都将会发送出去
        socket.setTcpNoDelay(true);
        // 看reuse包例子
        socket.setReuseAddress(true);
        // 在默认情况下,当调用了close后,将立即返回,如果这时仍然有未被消息被送出去的数据包,那么这些数据包将会丢弃,
        // 如果将linger参数设为一个正整数n时（n的值最大是65535），在调用close方法后，将最多被阻塞n秒。在这n秒内，
        // 系统将尽量将未送出的数据包发送出去；如果超过了n秒，如果还有未发送的数据包，这些数据包将全部被丢弃；
        // 而close方法会立即返回。如果将linger设为0，和关闭SO_LINGER选项的作用是一样的。
        socket.setSoLinger(true,60);
        // 如果将这个Socket选项打开,客户端Socket每隔端时间(大约两个小时)就会利用空闲连接向服务器发送一个数据包,
        // 这个数据包并没有其它的作用，只是为了检测一下服务器是否仍处于活动状态。如果服务器未响应这个数据包，
        // 在大约11分钟后，客户端Socket再发送一个数据包，如果在12分钟内，服务器还没响应，那么客户端Socket将关闭。
        // 如果将Socket选项关闭，客户端Socket在服务器无效的情况下可能会长时间不会关闭。
        socket.setKeepAlive(true);
        //  如果这个Socket选项打开，可以通过Socket类的sendUrgentData方法向服务器发送一个单字节的数据。
        // 这个单字节数据并不经过输出缓冲区，而是立即发出。
        // 如oobinline包例子
        socket.setOOBInline(true);
        //100字节
        socket.setSendBufferSize(100);
        //可以通过这个选项来设置读取数据超时。当输入流的read方法被阻塞时，如果设置timeout（timeout的单位是毫秒），
        // 那么系统在等待了timeout毫秒后会抛出一个InterruptedIOException。在抛出后，输入流并未关闭，你可以继续通过read方法读取数据。
        // 如果将timeout设为0，就意味着read将会无限等待下去
        socket.setSoTimeout(60);
        /*
            默认情况下套接字使用 tcp/ip 协议。有些实现可能提供与 tcp/ip 具有不同性能特征的替代协议。
            此方法允许应用程序在实现从可用协议中作出选择时表明它自己关于应该如何进行折衷的首选项。

            性能首选项由三个整数描述，它们的值分别指示短连接时间、低延迟和高带宽的相对重要性。
            这些整数的绝对值没有意义；为了选择协议，需要简单地比较它们的值，较大的值指示更强的首选项。
            例如，如果应用程序相对于低延迟和高带宽更希望短连接时间，则其可以使用值 (1, 0, 0) 调用此方法。
            如果应用程序相对于低延迟更希望高带宽，且相对于短连接时间更希望低延迟，则其可以使用值 (0, 1, 2) 调用此方法。
         */
        /*
            参数 connectionTime: 表示用最少时间建立连接.
            参数 latency: 表示最小延迟.
            参数 bandwidth: 表示最高带宽.
         */

        socket.setPerformancePreferences(1,2,3);
           /*
            * 低成本：发送成本低
            * 高可靠性：保证把数据可靠的送到目的地
            * 最高吞吐量：一次可以接收或者发送大批量的数据
            * 最小延迟：传输数据的速度快，把数据快速送达目的地
            * 低成本： 0x02
            * 高可靠性： 0x04
            * 最高吞吐量： 0x08
            * 最小延迟： 0x10
            */
        socket.setTrafficClass(0x02|0x04);

        //backlog是等待队列的大小
        int backlog=2;
        ServerSocket ss=new ServerSocket(8000,backlog);
    }
}
