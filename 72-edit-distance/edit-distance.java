class Solution {
    public int rec(int i,int j,String s,String t,int [][]dp){
        if(i==0){
            return dp[i][j]=j;
        }
        if(j==0){
            return dp[i][j]=i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=rec(i-1,j-1,s,t,dp);
        }
        int remove=1+rec(i-1,j,s,t,dp);
        int delete=1+rec(i,j-1,s,t,dp);
        int replace=1+rec(i-1,j-1,s,t,dp);

        return dp[i][j]=Math.min(remove,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return rec(n,m,word1,word2,dp);
    }
}