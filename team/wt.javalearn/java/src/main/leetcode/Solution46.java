package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 1   1
 * 2   2
 * 3   6
 * 4   24
 * Create by weicong on 2018/10/10
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int j) {
        if (j == nums.length) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int num : nums) temp.add(num);
            res.add(temp);
        }
        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(res, nums, j + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
