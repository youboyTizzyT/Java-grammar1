package leetcode;

import java.util.LinkedList;

/**
 * 无重复字符的最长子串
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int length=s.length();
        int max=0;
        char[] chars=s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (int i=0;i<length;i++){
            if (list.contains(chars[i])){
                max=list.size()>max?list.size():max;
                list=removelast(list,chars[i]);
            }
            list.add(chars[i]);
        }
        max=list.size()>max?list.size():max;
        return max;
    }
    LinkedList removelast(LinkedList<Character> l,char b){
        l.removeFirst();
        return l.contains(b)?removelast(l, b):l;
    }
}
