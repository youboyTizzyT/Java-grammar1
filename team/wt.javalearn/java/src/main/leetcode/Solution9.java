package leetcode;

/**
 * 回文数
 */
public class Solution9 {
    public static void main(String[] args) {
        Solution9 solution9 =new Solution9();
        System.out.println(solution9.isPalindrome(121));
    }
    public boolean isPalindrome(int x) {
        char[] chars=String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i]!=chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome2(int x) {
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        if(s.equals(reverse))
            return true;
        return false;
    }
}
