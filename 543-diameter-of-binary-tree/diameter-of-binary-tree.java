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
    public int height(TreeNode root){
        if(root==null ) return 0;
        if(root.left==null && root.right==null) return 0;
        return 1+Math.max(height(root.left),height(root.right)); 
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftdia=leftdia=diameterOfBinaryTree(root.left);
   
        int rightdia=diameterOfBinaryTree(root.right);
        
        int leftmax=height(root.left);
        int rightmax=height(root.right);
        int ans=leftmax+rightmax;
        if(root.left!=null) ans++;
        if(root.right!=null) ans++;
        return Math.max(ans,Math.max(rightdia,leftdia));
    }
}