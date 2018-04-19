package day10.http;

/**
 * Created by andilyliao on 16-10-5.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author weicong
 */
public class SimpleHttpGet {
    public static final String SEQUENCE = "\r\n";

    public static void main(String[] args) throws IOException {
        String host = "www.baidu.com";
        Socket socket = new Socket(host, 80);
        OutputStream os = socket.getOutputStream();
        StringBuffer head = new StringBuffer();
        // 这些是必须的
        head.append("GET / HTTP/1.1" + SEQUENCE);
        head.append("Host:").append(host).append(SEQUENCE).append(SEQUENCE);
        // 这些是可选的
        head.append("Accept:text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        head.append("Accept-Language:zh-CN,zh;q=0.8");
        head.append("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36");
        os.write(head.toString().getBytes());
        os.flush();
        InputStream is = socket.getInputStream();
        LineNumberReader lnr = new LineNumberReader(new InputStreamReader(is));
        StringBuffer headRes = new StringBuffer();
        String line = null;
        int contentLength = 0;
        do {
            line = lnr.readLine();
            headRes.append(line + SEQUENCE);
            if (line.startsWith("Content-Length")) {
                contentLength = Integer.parseInt(line.split(":")[1].trim());
            }
            // 由于LineNumberReader会把\r\n替换掉，所以如果读到一行为""证明http head结束
        } while (!line.equals(""));

        int totalCount = 0;
        byte[] buff = new byte[4096];
        StringBuffer contentRes = new StringBuffer();
        System.out.println(contentLength);
        while (totalCount < contentLength) {
            int len = is.read(buff);
            totalCount += len;
            System.out.println(len);
            contentRes.append(new String(buff, 0, len, "gbk"));
        }
        System.out.println(headRes.toString());
        System.out.println(contentRes.toString());
        socket.close();
    }
}
