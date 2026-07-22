/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean helper(TreeNode root,int target,int sum){
        if(root==null) return false;
        if(root.left==null && root.right==null){
            sum+=root.val;
            if(target==sum) return true;
            else return false;
        }
        return helper(root.left,target,sum+root.val) || helper(root.right,target,sum+root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
         return helper(root,targetSum,0);
    }
}