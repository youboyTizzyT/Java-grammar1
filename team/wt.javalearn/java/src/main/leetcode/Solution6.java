package leetcode;

import java.util.HashMap;

/**
 * 比较简单，击败了98玩家。
 */
public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution6=new Solution6();
        System.out.println(solution6.romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        char[] chars=s.toCharArray();
        int ret=0;
        int min=1000;
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i])>min){
                ret-=hashMap.get(chars[i-1])*2;
            }
            min=hashMap.get(chars[i]);
            ret+=min;
        }
        return ret;
    }
}
