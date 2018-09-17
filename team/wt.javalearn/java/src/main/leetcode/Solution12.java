package leetcode;

import java.util.HashMap;

/**
 *
 * 正数转罗马数
 * Create by weicong on 2018/9/14
 */
public class Solution12 {
    public String intToRoman(int num) {
        String[] M = new String[] { "", "M", "MM", "MMM" };
        String[] C = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] X = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] I = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
