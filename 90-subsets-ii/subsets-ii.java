class Solution {
    public void helper(int []nums, Set<List<Integer>> result,List<Integer> ans,int n){
        if(n==nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[n]);
        helper(nums,result,ans,n+1);
        ans.remove(ans.size()-1);
        helper(nums,result,ans,n+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result=new HashSet<>();
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        helper(nums,result,ans,0);
        List<List<Integer>> fin=new ArrayList<>(result);
        return fin;
    }
}