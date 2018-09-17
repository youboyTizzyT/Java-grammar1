package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树广度中序遍历
 * Create by weicong on 2018/9/14
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null)return null;
        List<Integer> ret=new ArrayList<>();
        if (root.left!=null){
            ret.addAll(inorderTraversal(root.left));
        }
        ret.add(root.val);
        if (root.right!=null){
            ret.addAll(inorderTraversal(root.right));
        }
        return ret;
    }

}
