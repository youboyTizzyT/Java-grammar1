package leetcode;


/**
 * 实现strStr()
 * Create by weicong on 2018/9/14
 * abcabcab
 * sakfljaabcababc
 */
public class Solution22 {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        int ii =0;
        int ret=-1;
        if (haystack.length()<needle.length()){
            return ret;
        }
        if (haystack.equals(needle)){
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i)==needle.charAt(ii)){
                ii++;
                if (ret==-1){
                    ret=i;
                }
            }else if(ii!=0){
                i-=ii;
                ii=0;
                ret=-1;
            }
            if (ii==needle.length()){
                return ret;
            }
        }
        return -1;
    }

    public static void main(String[] args) {


        System.out.println(strStr("aaa","a"));
    }
}
