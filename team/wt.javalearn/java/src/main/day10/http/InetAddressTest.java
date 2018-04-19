package day10.http;

import java.net.InetAddress;

/**
 * @author weicong
 * @date 2018/4/18 0018
 */
public class InetAddressTest {
    public static void main(String[] args)
            throws Exception {
        //inet4 inet6
        // 根据主机名来获取对应的InetAddress实例
        InetAddress ip = InetAddress.getByName("localhost");
        // 判断是否可达
        System.out.println("localhost是否可达：" + ip.isReachable(2000));
        // 获取该InetAddress实例的IP字符串
        System.out.println(ip.getHostAddress());
        // 根据原始IP地址来获取对应的InetAddress实例
        InetAddress local = InetAddress.getByAddress(
                new byte[]{127, 0, 0, 1});
        System.out.println("本机是否可达：" + local.isReachable(5000));
        // 获取该InetAddress实例对应的全限定域名
        System.out.println(local.getCanonicalHostName());
    }
}
