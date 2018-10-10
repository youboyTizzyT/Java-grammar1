package leetcode;

/**
 * Create by weicong on 2018/10/10
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{-1,-1};
        }
        int first=-1;
        int last=-1;
        for (int n = 0; n < nums.length; n++) {
            if (nums[n]==target){
                if (first==-1){
                    first=n;
                }
                if (last<n){
                   last=n;
                }
            }
        }
        return new int[]{first,last};
    }
}
