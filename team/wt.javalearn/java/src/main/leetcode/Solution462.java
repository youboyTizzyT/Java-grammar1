package leetcode;

import java.util.Arrays;

public class Solution462 {
    public static int minMoves2(int[] nums) {
        if (nums.length==2){
            return Math.abs(nums[1]-nums[0]);
        }else if (nums.length==1||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int first=0;
        int last=nums.length-1;
        int sum=0;
        while (first!=last){
            if (first+1>last-1){
                if ((nums[first+1]-nums[first])*first+1>(nums[last]- nums[last-1])*first+1){
                    sum+=(nums[last]- nums[last-1])*(first+1);
                }else {
                    sum+=(nums[first+1]-nums[first])*(first+1);
                }
                return sum;
            }
            sum+=(nums[first+1]-nums[first])*(first+1);
            sum+=(nums[last]- nums[last-1])*(first+1);
            first++;
            last--;
        }
        return sum;
    }
}
