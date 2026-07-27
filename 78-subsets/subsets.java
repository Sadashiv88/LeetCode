class Solution {
    public void helper(int []nums,List<List<Integer>> result,List<Integer> ans,int n){
        if(n==nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[n]);
        helper(nums,result,ans,n+1);
        ans.remove(ans.size()-1);
        helper(nums,result,ans,n+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        helper(nums,result,ans,0);
        return result;
    }
}