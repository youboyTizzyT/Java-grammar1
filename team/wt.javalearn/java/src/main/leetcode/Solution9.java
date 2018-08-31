package leetcode;

import com.google.common.primitives.Ints;

import java.util.*;

public class Solution9 {

    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap hashMap=new HashMap();
        List<List<Integer>> ret=new LinkedList<>();
        if (nums.length<3){
            return ret;
        }
        OUT:
        while (nums.length>=3){
            for (int i = 0; i < nums.length; i++) {
                for (int j=1;j<nums.length;j++){
                    for (int n=2;n< nums.length;n++){
                        if (nums[i]+nums[j]+nums[n]==0){
                            List<Integer> list=new LinkedList<>();
                            list.add(nums[n]);
                            list.add(nums[j]);
                            list.add(nums[i]);
                            remove(nums,nums[n]);
                            remove(nums,nums[i]);
                            remove(nums,nums[j]);
                            ret.add(list);
                            break OUT;
                        }
                    }
                }
                return ret;
            }
        }

        return ret;
    }
    static int[] remove (int[] arr ,int b){
        int index=-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==b){
                index=i;
                break;
            }
        }
        arr[index] = arr[arr.length-1];

        arr = Arrays.copyOf(arr, arr.length-1);
        return arr;
    }

    public static void main(String[] args) {
        int[] i={1,85,-3,8,2,13,1,56,13,156,541};
        System.out.println(threeSum(i));
    }
}
