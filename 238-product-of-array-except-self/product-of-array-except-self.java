class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int pref[]=new int[n];
        int suff[]=new int[n];
        int pre=1;
        int suf=1;
        int fin[]=new int[n];
        for(int i=0;i<n;i++){
            pre=pre*nums[i];
            pref[i]=pre;
            suf=suf*nums[n-i-1];
            suff[n-i-1]=suf;

        }
        fin[0]=suff[1];
        fin[n-1]=pref[n-2];
        for(int i=1;i<n-1;i++){
            fin[i]=pref[i-1]*suff[i+1];
        }
        return fin;
    }
}