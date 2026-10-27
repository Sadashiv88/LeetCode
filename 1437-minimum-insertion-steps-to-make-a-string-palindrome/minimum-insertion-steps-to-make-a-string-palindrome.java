class Solution {
    public int longestcommonsubsequence(String s,String t){
        int n=s.length();
        int m=t.length();
        int dp[][]=new int [n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int longestPalindromic(String s){
        StringBuilder st=new StringBuilder("");
        for(int i=s.length()-1;i>=0;i--){
            st.append(s.charAt(i)+"");
        }
        String t=st.toString();
        return longestcommonsubsequence(s, t);
    }
    public int minInsertions(String s) {
        return s.length()-longestPalindromic(s);
    }
}