package leetcode;

import javax.swing.tree.TreeNode;
import java.util.*;

public class SolutionWeek {
    public static void main(String[] args) {
        int[] a={1,1,2};
        SolutionWeek solutionWeek=new SolutionWeek();
        System.out.println(solutionWeek.subarrayBitwiseORs(a));
    }
    public boolean isMonotonic(int[] A) {
        if (A.length<2){
            return true;
        }
        int a=0;
        for (int i = 1; i < A.length; i++) {
            if (A[i-1]>A[i]){
                if (a==1){
                    continue;
                }
                if (a==0){
                    a=1;
                }
                if (a==2){
                    return false;
                }
            }else if (A[i-1]<A[i]){
                if (a==2){
                    continue;
                }
                if (a==0){
                    a=2;
                }
                if (a==1){
                    return false;
                }
            }else {
                continue;
            }
        }
        return true;
    }

    public String orderlyQueue(String S, int K) {
        char[] chars=S.toCharArray();
        int Max=0;
        for (int i = 0; i < K ; i++) {
            Max=chars[i]>Max?Max=i:Max;
            char[] chars1=new char[chars.length];


        }
return null;
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
    public int subarrayBitwiseORs(int[] A) {
        Set list=new HashSet();
        list.add(A);
        for (int i = 2; i <= A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int aaa=0;
                for (int k = 0; k < i; k++) {
                    if ((j+k)>=A.length){
                        break;
                    }
                    aaa+=A[j+k];
                }
                list.add(aaa);
            }
        }
        return list.size();
    }


}
