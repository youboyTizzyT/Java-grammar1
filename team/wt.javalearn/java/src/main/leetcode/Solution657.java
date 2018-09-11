package leetcode;

import java.util.HashMap;

/**
 * 机器人能否返回原点
 * Create by weicong on 2018/9/11
 * @author 小米电脑
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        HashMap<String,Integer> hashMap=new HashMap<>(4);
        hashMap.put("R",0);
        hashMap.put("L",0);
        hashMap.put("U",0);
        hashMap.put("D",0);
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i)=='R'){
                hashMap.put("R",hashMap.get("R")+1);
            }if (moves.charAt(i)=='L'){
                hashMap.put("L",hashMap.get("L")+1);
            }if (moves.charAt(i)=='U'){
                hashMap.put("U",hashMap.get("U")+1);
            }if (moves.charAt(i)=='D'){
                hashMap.put("D",hashMap.get("D")+1);
            }
        }
        if (hashMap.get("U")-hashMap.get("D")==0&&hashMap.get("R")-hashMap.get("L")==0){
            return true;
        }
        return false;
    }
}
