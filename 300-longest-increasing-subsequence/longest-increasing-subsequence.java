class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        // int dp[][]=new int[n][n+1];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=n;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return rec(0,-1,nums,dp);
        return longestIncreasingSubsequence(nums,n);
    }
    public int rec(int i,int prev,int []nums,int [][]dp){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int len=rec(i+1,prev,nums,dp);
        if(prev==-1 || nums[i]>nums[prev]){
            len=Math.max(len,1+rec(i+1,i,nums,dp));
        }
        return dp[i][prev+1]=len;
    }
     public  int longestIncreasingSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }
}