package leetcode;

/**
 * 找最长公共字符串
 */
public class Solution7 {
    public static void main(String[] args) {
        String[] strs={"qweasd","qweasx",""};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0)return "";
        String ret=strs[0];
        int carry=ret.length();
        for (int i = 1; i < strs.length; i++) {
            for (int j=0;j<ret.length();j++) {
                if (!ret.regionMatches(0, strs[i], 0, carry)){
                    carry--;
                }else break;
            }
            ret=ret.substring(0,carry);
        }
        return ret;
    }
}
