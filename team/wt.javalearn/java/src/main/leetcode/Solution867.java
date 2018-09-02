package leetcode;

import java.util.Arrays;

/**
 * 转置矩阵
 * @author 魏琮
 */
public class Solution867 {
    public static void main(String[] args) {
        int[][] a={{1,1,1,1,1},{2,2,2,2,2}};
        Solution867 solution867=new Solution867();
        System.out.println(Arrays.toString(solution867.transpose(a)));
    }
    public int[][] transpose(int[][] A) {
        int[][] ret=new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                ret[j][i]=A[i][j];
            }
        }
        return ret;
    }
}
