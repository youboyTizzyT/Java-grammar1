package leetcode;

import java.util.Arrays;

/**
 * 缺失的第一个正数
 * Create by weicong on 2018/9/17
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int a = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<a){
                continue;
            }
            if (nums[i]==a){
                a++;
            }
            if (nums[i]>a){
                return a;
            }
        }
            return a+1;
        }


    public static void main(String[] args) {
        Solution41 solution41=new Solution41();
        System.out.println(solution41.firstMissingPositive(new int[]{3,4,-1,1}));

    }
}
