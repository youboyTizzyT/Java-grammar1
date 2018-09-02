package leetcode;

import java.util.Arrays;

/**
 *
 * @author 小米电脑
 */
public class Solution189 {
    public int[] rotate(int[] nums, int k) {
        if (k==0){
            return nums;
        }
        int[] temp= Arrays.binarySearch(nums,nums.length-k,nums.length);

    }
}
