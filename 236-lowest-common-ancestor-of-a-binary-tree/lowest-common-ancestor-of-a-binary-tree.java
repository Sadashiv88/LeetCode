/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean contains(TreeNode root,TreeNode p){
        if(root==null) return false;
        if(root==p) return true;
        return contains(root.left,p) || contains(root.right,p);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if (root == null) return null;
        if (root == p || root == q) return root;

        boolean pLeft = contains(root.left, p);
        boolean qLeft = contains(root.left, q);

        if (pLeft && qLeft)
            return lowestCommonAncestor(root.left, p, q);

        if (!pLeft && !qLeft)
            return lowestCommonAncestor(root.right, p, q);

        return root;



    }
}