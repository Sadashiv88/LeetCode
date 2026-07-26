class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=nums[0];
        if(n>1) dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int pick=Integer.MIN_VALUE;
            if(i>1) pick=nums[i]+dp[i-2];
            int notpick=dp[i-1];
            dp[i]=Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}