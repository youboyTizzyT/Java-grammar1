package leetcode;

import java.util.Arrays;

/**
 *
 * @author 小米电脑
 */
public class Solution189 {
    public static void main(String[] args) {
        Solution189 solution189=new Solution189();
        int[] aaa={1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(solution189.rotate(aaa,3)));
    }
    public int[] rotate(int[] nums, int k) {
        if (k>=nums.length){
            int c=k/nums.length;
            k-=c*nums.length;
        }
        System.out.println(k);
        if(nums.length<=1){return nums;}
        int[] nums1=Arrays.copyOf(nums,nums.length);
        for (int i = 0; i < nums.length; i++) {
            int a=i+nums.length-k;
            if (a>=nums.length)a-=nums.length;
            nums[i]=nums1[a];
        }
        return nums;
    }
}
