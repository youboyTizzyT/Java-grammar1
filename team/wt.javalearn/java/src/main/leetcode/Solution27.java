package leetcode;

/**
 * 删除数组中的元素
 * Create by weicong on 2018/9/17
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int move=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==val){
                move++;
            }else if (move>0){
                swap(nums,i,i-move);
            }
        }
        return nums.length-move;
    }
    public void swap(int[] nums,int i,int b){
        nums[i]^=nums[b];
        nums[b]^=nums[i];
        nums[i]^=nums[b];
    }
}
