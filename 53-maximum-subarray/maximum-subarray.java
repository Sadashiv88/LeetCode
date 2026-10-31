class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int maxi=-(int)1e8;
        for(int i=0;i<nums.length;i++){
            if(sum<0) sum=0;
            sum+=nums[i];
            if(sum>maxi){
                maxi=sum;
                
            }
        }
        return maxi;
    }
}