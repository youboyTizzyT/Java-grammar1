package leetcode;

import java.util.HashMap;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        digits=digits.replaceAll("1","").replaceAll("0","0");
        HashMap hashMap=new HashMap();
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        int lenth=digits.length();
        for (int i = 0; i < lenth; i++) {
            
        }

    }
}
