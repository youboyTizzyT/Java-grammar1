package leetcode;

/**
 * 两数相除
 * Create by weicong on 2018/9/18
 */
public class Solution29 {
    public static void main(String[] args) {
        Solution29 solution29=new Solution29();
        System.out.println(solution29.divide(-2147483648,-1));
//        System.out.println((-2147483648)/(-1));
    }

    public int divide(int dividend, int divisor) {
        int ret=0;

//        if (Math.abs(divisor)==1){
//            ret= dividend*divisor;
//        }
        //符号位
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        // 求绝对值，为防止溢出使用long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        while(dvd>=dvs){
            long tmp = dvs;
            long mul = 1;

            while(dvd >= (tmp << 1)){
                tmp <<= 1;
                mul <<= 1;
            }
            //减去最接近dvd的dvs的指数倍数的值（值为tmp）
            dvd -= tmp;
            System.out.println(ret);
            ret= ret+mul<ret?Integer.MAX_VALUE: (int) (ret + mul);
//            ret +=mul;
        }
        System.out.println(ret);
        if (ret<0&&sign==1){
            ret=Integer.MAX_VALUE;
        }
        return ret*sign;
    }
}
