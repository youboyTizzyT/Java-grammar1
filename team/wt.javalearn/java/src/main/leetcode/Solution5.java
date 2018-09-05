package leetcode;

import com.google.common.base.Strings;

public class Solution5 {
    public static void main(String[] args) {
        long a=System.currentTimeMillis();
        System.out.println(longestPalindrome1("wqwqw"));
        System.out.println(System.currentTimeMillis()-a);
    }

    /**
     * 这套代码时间超出限制
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length()<1) {
            return s;
        }
        String ret=s.substring(0,1);
        int max=1;
        for (int i = 0; max+i < s.length();i++) {
            int n=max;
            while (n+i<=s.length()) {
                if (isHuiWen(s.substring(i,n+i))) {
                    ret = s.substring(i,n+i).length() > ret.length() ? s.substring(i, n+i) : ret;
                    max=n;
                }
                n++;
            }
        }
        System.out.println(max);
        return ret;
    }
    public static boolean isHuiWen(String s){
        StringBuffer sb = new StringBuffer(String.valueOf(s));
        return sb.reverse().toString().equals(s);
    }

    /**
     * 这种方式不是从开始遍历最后的，而是遍历一遍，由中间向外分扩。
     * 对奇数和偶数有所区分。
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s){
            if (s==null||s.length()<1)return "";
            int start=0,end=0;
        for (int i = 0; i < s.length(); i++) {
            int len1=expandAroundCenter(s,i,i);
            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if (len>end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private static int expandAroundCenter(String s ,int left,int right){
        int l =left;
        int r =right;
        while (l >=0&&r <s.length()&&s.charAt(l )==s.charAt(r )){
            l --;
            r ++;
        }
        return r -l -1;
    }
    public String longestPalindrome2(String s) {
        if(s.length()<=1) return  s;
        char[] characters = s.toCharArray();
        //用于存放str中最长回文子串所对应的下标
        int[] range = {0,1};
        for(int i = 0;i<characters.length;i++){
            i = helper(i,characters,range);
        }
        return s.substring(range[0],range[1]);
    }

    private int helper(int index,char[] c,int[] range) {
        int low = index;
        int high = index;
        //如果遇到相同字符，则high进位，如abba ，这样偶回文子串也可以当做奇回文处理了
        while(high<c.length-1 && c[high]==c[high+1]){
            high++;
        }
        int cursor = high;

        while(high+1<c.length&&low-1>=0&&c[low-1]==c[high+1]){
            low--;
            high++;
        }
        if(high-low+1>range[1]-range[0]){
            range[0] = low;
            range[1] = high + 1;
        }
        return cursor;
    }

    public String longestPalindrome3(String s) {
        int maxLength = 0;
        String maxSubString = "";
        if(s!=null){
            maxSubString = s.substring(0,1);
            for(int i = 0;i<s.length();i++){
                maxLength = 1;
                int small = i-1;
                int large = i+1;

                while(small>=0&&s.charAt(small)==s.charAt(i)){
                    maxLength++;
                    if(maxLength>maxSubString.length()){
                        maxSubString = s.substring(small, i+1);
                    }
                    small--;
                }
                while(large<s.length()&&s.charAt(large)==s.charAt(i)){
                    maxLength++;
                    if(maxLength>maxSubString.length()){
                        maxSubString = s.substring(i, large+1);
                    }
                    large++;
                }
                while(small>=0&&large<s.length()){
                    if(s.charAt(small)==s.charAt(large)){
                        maxLength = maxLength+2;
                        if(maxLength>maxSubString.length()){
                            maxSubString = s.substring(small, large+1);
                        }
                    }else{
                        if(maxLength>maxSubString.length()){
                            maxSubString = s.substring(small, large);
                        }
                        break;
                    }
                    small--;
                    large++;
                }
            }
        }
        return maxSubString;
    }
}
