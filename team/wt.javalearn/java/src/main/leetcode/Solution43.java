package leetcode;

/**
 * 字符串想乘
 *
 * @Author weicong
 * @Date 2019 2019/2/1 5:32 PM
 * @Version 1.0
 * @Description TODO
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1)||"0".equals(num2)){
            return "1";
        }
        if ("1".equals(num1)||"1".equals(num2)){
            return "1".equals(num1)?num2:num1;
        }
        char[] num1c=num1.toCharArray();
        char[] num2c=num2.toCharArray();

        StringBuilder ret=new StringBuilder();
        // 每次定位一位数的10位数
        int last=0;
        // 每次定位以为数的个位数
        int tmp=0;
        for (int i = 0; i <num1.length()+num2.length()-1; i++) {
            tmp=last;
            last=0;
            for (int j = 0; j <= i; j++) {
                if (i>num1.length()-1||i>num2.length()-1)continue;
                int a=num1c[num1.length()-j-1]-48;
                int b= num2c[num2.length()-i + j-1]-48;
                tmp+=a*b ;
            }
            if (tmp>9){
                last+=tmp/10;
            }
            ret.append(tmp%10);
        }
        return ret.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(4%10);
        Solution43 solution43=new Solution43();
        System.out.println(solution43.multiply("21","34"));
    }
}