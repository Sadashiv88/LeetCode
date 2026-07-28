class Solution {
    int maxi;
    public void helper(int target,List<Integer> nums,List<Integer> ans,int n,int sum){
        if(n==nums.size()){
            if(target==sum){
                maxi=Math.max(maxi,ans.size());
            }
            return;
        }
        sum+=nums.get(n);
        ans.add(nums.get(n));
        helper(target,nums,ans,n+1,sum);
        sum-=nums.get(n);
        ans.remove(ans.size()-1);
        helper(target,nums,ans,n+1,sum);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        // ArrayList<Integer> ans=new ArrayList<>();
        //  maxi=-1;
        // helper(target,nums,ans,0,0);
        // return maxi;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int num : nums) {
            for (int sum = target; sum >= num; sum--) {
                if (dp[sum - num] != -1) {
                    dp[sum] = Math.max(dp[sum], dp[sum - num] + 1);
                }
            }
        }

        return dp[target];
    }
}