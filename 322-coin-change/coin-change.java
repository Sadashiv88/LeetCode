class Solution {
    public int rec(int i,int []coins,int k,int [][]dp){
        if(i==0){
            if(k%coins[0]==0) return k/coins[0];
            else return (int) 1e8;
        }
        if(dp[i][k]!=-1) return dp[i][k];
        int pick=(int)1e8;
        if(k>=coins[i]) pick=1+rec(i,coins,k-coins[i],dp);
        int notpick=rec(i-1,coins,k,dp);
        return dp[i][k]=Math.min(pick,notpick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
       if (amount == 0)
            return 0;
       
         
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        
        int ans = rec(n - 1, coins, amount, dp);

        return ans >= (int) 1e8 ? -1 : ans;
    }
}