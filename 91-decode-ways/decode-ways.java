class Solution {
    public int  rec(String s,int i,int dp[]){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        if(dp[i]!=-1) return dp[i];
        int ways=rec(s,i+1,dp);
        
        if(i<s.length()-1){
            int two=Integer.parseInt(s.substring(i,i+2));
            if(two>=10 && two<=26){
                ways+=rec(s,i+2,dp);
            }
        }
        return dp[i]=ways;
        
    }
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return rec(s,0,dp);
        //return dp[n-1];
    }
}