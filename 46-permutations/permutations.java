class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        boolean vis[]=new boolean[nums.length];
        rec(nums,vis,ans,ls);
        return ans;
    }
    public void rec(int []nums,boolean vis[],List<List<Integer>> ans,List<Integer> ls){
        if(ls.size()==nums.length){
            ans.add(new ArrayList(ls));
            return;

        }
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                ls.add(nums[i]);
                rec(nums,vis,ans,ls);
                ls.remove(ls.size()-1);
                vis[i]=false;
            }
        }
    }
}