class Solution {
    public int helper(String s,int n,int []dp){
        if(n==s.length()) return 1;
        if(s.charAt(n)=='0') return 0;
        if(n>s.length()) return 0;
        if(dp[n]!=-1) return dp[n];
        int ways=helper(s,n+1,dp);
        if(n<s.length()-1){
            //int two=Integer.parseInt(s.subString(n,n+2));
            int two=Integer.parseInt(s.substring(n,n+2));
            if(two>=10 && two<=26){
                ways+=helper(s,n+2,dp);
            }
        }
        return dp[n]= ways;
    }
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        
        return helper(s,0,dp);
    }
}