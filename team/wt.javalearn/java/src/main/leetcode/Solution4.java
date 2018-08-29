package leetcode;

/**
 * 翻转整数
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4=new Solution4();
        System.out.println(solution4.reverse(1534236469));
    }
    public int reverse(int x) {
        if (x==0)return 0;
        String s=String.valueOf(x);
        char[] chars=s.toCharArray();
        StringBuffer sb=new StringBuffer();
        int carry=0;
        if (chars[0]=='-'){
            sb.append('-');
            carry=1;
        }
        for (int i = chars.length-1; i >=carry; i--) {
            if (i==chars.length-1&&chars[i]=='0')continue;
            sb.append(chars[i]);
        }
        try {
            return Integer.valueOf(sb.toString());
        }catch (NumberFormatException e){
            return 0;
        }

    }

    /**
     * 最快速度的答案
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int next = x;
    /*
     pop:反转数——余数
      */
        int pop = 0;
        int result = 0;
        do {
            pop = next % 10;
            next /= 10;
            // 判断是否溢出

            // MIN: -2147483648
            if (result < Integer.MIN_VALUE / 10 || result * 10 == Integer.MAX_VALUE && pop < -8) {
                return 0;
            }
            // MAX:  2147483647
            if (result > Integer.MAX_VALUE / 10 || result * 10 == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            result = result * 10 + pop;
        }
        while (next != 0);
        return result;
    }
}
