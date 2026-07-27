class Solution {
    public int helper(int i,int prev,int[]nums,int n,int [][]dp){
        if(i==n) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int len=helper(i+1,prev,nums,n,dp);
        
        if(prev==-1 || nums[prev]<nums[i]){
            len=Math.max(len,1+helper(i+1,i,nums,n,dp));
        }
        return dp[i][prev+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,-1,nums,n,dp);

    }
}