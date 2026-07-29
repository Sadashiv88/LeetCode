class Solution {
    static Boolean dp[];
    public boolean check(int []nums,int n){
        if(n>=nums.length-1) return true;
        if(dp[n]!=null) return dp[n];
        int s=nums[n];
        if(s==0) return false;
        int total=s+n;
        total=Math.min(total,nums.length-1);
        for(int i=n+1;i<=total;i++){
            if(check(nums,i)){
                return dp[n]=true;
            }
        }
        return dp[n]=false;
    }
    public boolean canJump(int[] nums) {
        dp=new Boolean[nums.length];
        return check(nums,0);
    }
}