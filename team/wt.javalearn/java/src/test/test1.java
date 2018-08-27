import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        int[] a={2,7,11,15};
        System.out.println(Arrays.toString(test1.twoSum(a,9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] b=new int[2];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    b[0]=i;
                    b[1]=j;
                }
            }
        }
        return b;
    }
    /**
     * @Description: 将base64编码字符串转换为图片
     * @Author:
     * @CreateTime:
     * @param imgStr base64编码字符串
     * @param path 图片路径-具体到文件
     * @return
     */
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null)
                return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
                // 解密
                byte[] b = decoder.decodeBuffer(imgStr);
                // 处理数据
                for (int i = 0; i < b.length; ++i) {
                        if (b[i] < 0) {
                                b[i] += 256;
                        }
                }
                OutputStream out = new FileOutputStream(path);
                out.write(b);
                out.flush();
                out.close();
                return true;
        } catch (Exception e) {
                return false;
        }
    }
    /**
     * @Description: 根据图片地址转换为base64编码字符串
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}

