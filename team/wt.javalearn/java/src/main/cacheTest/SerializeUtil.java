package cacheTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化对象工具
 *
 * @author weicong
 * @create 2017 01 04 16:54
 */
public class SerializeUtil {
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos=null;
        ByteArrayOutputStream baos=null;
        byte[] bytes=null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bytes = baos.toByteArray();
        } catch (Throwable e) {
            System.out.println("serialize error");
        }finally {
            try {
                baos.close();
                oos.close();
                return bytes;
            }catch (Throwable e){
                System.out.println("close outputStream error");
            }
        }
        return null;
    }

    public static Object unserialize( byte[] bytes) {
        ByteArrayInputStream bais=null;
        ObjectInputStream ois=null;
        Object object=null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
            object = ois.readObject();
        } catch (Throwable e) {
            System.out.println("unserialize error");
        }finally {
            try {
                bais.close();
                ois.close();
                return object;
            } catch (Throwable e) {
                System.out.println("close inputStream error");
            }
        }
        return null;
    }
}
