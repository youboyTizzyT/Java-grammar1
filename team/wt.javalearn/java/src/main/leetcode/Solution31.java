package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create by weicong on 2018/9/17
 */
public class Solution31 {
    public int[] nextPermutation(int[] nums) {
        boolean is=true;
        for (int n = nums.length-1; n >= 0&&is; n--) {
            if (n==nums.length-1)continue;
            if (nums[n]<nums[n+1]){
                is=false;
                int i=Integer.MAX_VALUE;
                int i1=n;
                for (int j = n+1; j < nums.length; j++) {
                    if (i > nums[j] - nums[n] && nums[j] - nums[n] > 0) {
                        i = i = nums[j] - nums[n];
                        i1=j;
                        if (i==1){
                            continue;
                        }
                    }

                }
                swap(nums,n,i1);
                sort(nums,n+1);
            }
        }
        if (is){
            Arrays.sort(nums);
        }
        return nums;
    }
//    1321  =>2113
    public void swap(int[] nums,int i,int p){
        nums[i]^=nums[p];
        nums[p]^=nums[i];
        nums[i]^=nums[p];
    }
    private void sort(int[] nums, int begin) {
        int end = nums.length - 1;
        for (int i = begin; i < end; i++) {
            for (int j = begin; j < end - i + begin; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution31 solution31=new Solution31();
        System.out.println(Arrays.toString(solution31.nextPermutation(new int[]{3,6,5,4,3,2,1})));
    }
}
