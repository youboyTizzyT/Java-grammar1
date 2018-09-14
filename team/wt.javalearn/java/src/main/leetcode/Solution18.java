package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * Create by weicong on 2018/9/14
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 返回值
        List<List<Integer>> result = new ArrayList<>();
        // 判断是否够4哥长度
        if(nums.length<4){
            return result;
        }
        // 排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            // nums[i]加上剩下最小的4个数，那只能放弃。
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            // num[i] 加上剩下最大的3个数，那就跳过这次，让nums[i]变大点。
            if(nums[i] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3] < target){
                continue;
            }
            //跳过重复项  必须第二次循环。
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            // 第二次for循环
            for(int j=i+1;j<nums.length-2;j++){
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2] > target){
                    break;
                }
                if(nums[i]+nums[j]+nums[nums.length-1] + nums[nums.length-2] < target){
                    continue;
                }
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
