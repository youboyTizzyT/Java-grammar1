package leetcode;
/**
 * 盛最多水的容器
 */
public class Solution8 {
    public static void main(String[] args) {
        int[] a={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
    public static int maxArea(int[] height) {
        if(height.length<=1){
            return 0;
        }
        int ret=0;
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){

                ret=((j-i)*(height[j]>height[i]?height[i]:height[j]))>ret?((j-i)*(height[j]>height[i]?height[i]:height[j])):ret;
            }
        }
        return ret;
    }
    public static int maxArea1(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(right > left){
            max = Math.max(max,(Math.min(height[right],height[left])*(right-left)));
            if (height[left] > height[right]) right--;
            else left++;
        }
        return max;
    }
}
