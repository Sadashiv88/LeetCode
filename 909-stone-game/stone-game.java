class Solution {
      public int solve(int i, int j, int[] nums, int[][] dp) {
        if (i >j ) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int pickLeft = nums[i] +Math.min(solve(i+2,j,nums,dp),solve(i+1,j-1,nums,dp));
        int pickRight = nums[j] +Math.min(solve(i,j-2,nums,dp),solve(i+1,j-1,nums,dp));

        return dp[i][j] = Math.max(pickLeft, pickRight);
       
    }
    public boolean stoneGame(int[] nums) {
            int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        int sum=0;
        for(int it:nums){
            sum+=it;
        }
        int s=solve(0,n-1,nums,dp);
        if(sum/2 >s) return false;
        return true;
    }
}