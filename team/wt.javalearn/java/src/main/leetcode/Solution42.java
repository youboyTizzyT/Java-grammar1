package leetcode;

/**
 * 接雨水
 * Create by weicong on 2018/9/18
 */
public class Solution42 {
    public int trap(int[] height) {
        int ret=0;
        int l=0;
        int tmp=0;
        for (int i = 0; i < height.length; i++) {
            if (i==0) {
                l=height[i];
                continue;
            }else {
                if (height[i]<l){
                    tmp+=l-height[i];
                }
            }

        }
        return tmp;
    }
}
