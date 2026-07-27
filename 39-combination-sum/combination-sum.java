class Solution {
    public void helper(int[]nums,int target,List<List<Integer>> result,List<Integer> ans,int n,int sum){
        if(sum>target) return;
        if(sum==target){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(n==nums.length){
            if(sum==target){
                result.add(new ArrayList<>(ans));
                return;
            }else{
                return;
            }
        }
        ans.add(nums[n]);
        sum+=nums[n];
        helper(nums,target,result,ans,n,sum);
        ans.remove(ans.size()-1);
        sum-=nums[n];
        helper(nums,target,result,ans,n+1,sum);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        helper(candidates,target,result,ans,0,0);
        return result;
    }
}