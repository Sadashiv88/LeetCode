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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        while(!q.isEmpty()){
            int sizi=q.size();
            List<Integer> ans=new ArrayList<>();
            for(int i=1;i<=sizi;i++){
                TreeNode p=q.poll();
                
                ans.add(p.val);
                if(p.left!=null) q.add(p.left);
                if(p.right!=null) q.add(p.right);

            }
            result.add(ans);
        }
        return result;
    }
}