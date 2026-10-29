class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int dp[][][]=new int [n][n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int player1=solve(0,n-1,nums,dp,0);
        int player2=sum-player1;

        if(player1>=player2) return true;
        return false;
    }
    public int solve(int i,int j,int []nums,int [][][]dp,int turn){
        if(i>j) return 0;
        if(dp[i][j][turn]!=-1) return dp[i][j][turn];
        int result=0;
        if(turn==0){
            int left=nums[i]+solve(i+1,j,nums,dp,1);
            int right=nums[j]+solve(i,j-1,nums,dp,1);
            
            result=Math.max(left,right);
        }else{
            int left=solve(i+1,j,nums,dp,0);
            int right=solve(i,j-1,nums,dp,0);

            result=Math.min(left,right);
        }
        return dp[i][j][turn]=result;

    }
}