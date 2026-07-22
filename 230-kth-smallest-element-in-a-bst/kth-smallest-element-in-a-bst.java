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
    static int flag=-1;
    static int count=0;
    public void helper(TreeNode root,int k){
        if(root==null) return ;
        helper(root.left,k);
        count++;
        if(k==count){
            flag=root.val;
            return;
            
        }
        
        helper(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        flag=-1;
        count=0;
        helper(root,k);
        return flag;
    }
}