package leetcode;

/**不同的二叉搜索树
 * 0    1                                                   1
 * 1    0*0=1*1                                             1
 * 2    1*0+1*0=1*1                                         2
 * 3    2*0+1*1+0*2=2*1+1+1*2                               5
 * 4    3 0+2 1+1 2+  3                                        14
 * 5    4 0+3 1++2 2+1 3+0 4
 * Create by weicong on 2018/9/17
 */
public class Solution96 {
    public int numTrees(int n) {
        if (n==1||n==0){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int ret=0;
        for (int i = 0; i < n/2; i++) {
            ret+=2*numTrees(n-1-i)*numTrees(i);
        }
        if (n%2==1){
            ret+=Math.pow(numTrees((n-1)/2),2);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution96 s=new Solution96();
        System.out.println(s.numTrees(19));
    }
}
