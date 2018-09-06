package leetcode;

import java.util.*;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> result = new LinkedList<>();//结果集
        if(digits.length()==0){
            return result;
        }
        Queue<StringBuilder> queue = new LinkedList<>();//队列
        queue.add(new StringBuilder());//先在队列中添加一个新的空字符串

        for (int i = 0; i < digits.length(); ++i){//循环所有输入的数字
            int limitSize = queue.size();//记录每次出队列之前的元素的个数
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1'){//如果数字是0或1,因为没有对应的字母，则跳过
                continue;
            }
            int tar = digits.charAt(i) - '0';
            int j = 0;//用于将queue中的元素依次出队列
            while (!queue.isEmpty() && j < limitSize){//循环j将limitsize个元素依次出队列
                StringBuilder stringBuilder1 = queue.poll();//每次将队列头一个stringBuilder出队列
                for (char x: map.get(tar).toCharArray()){//循环每一个数字对应的字母，依次加入到队列中
                    StringBuilder tmp = new StringBuilder(stringBuilder1);//获得每一个出对列的stringBuilder，并将后面的字母append到后面
                    tmp.append(x);
                    queue.add(tmp);//将stringBuilder加入到队列中
                }
                ++j;
            }
        }
        while (!queue.isEmpty()){
            result.add(queue.poll().toString());//依次将队列中的字符串加入到结果集中
        }
        return result;
    }
}
