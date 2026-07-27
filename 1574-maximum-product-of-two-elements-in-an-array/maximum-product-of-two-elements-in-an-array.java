class Solution {
    public int maxProduct(int[] nums) {
       int maxi1=nums[0];
       int maxi2=Integer.MIN_VALUE;
       for(int i=1;i<nums.length;i++){
            if(nums[i]>=maxi1){
                maxi2=maxi1;
                maxi1=nums[i];
            }else if(nums[i]>maxi2 && nums[i]<maxi1){
                maxi2=nums[i];
            }
       }
       return (maxi1-1)*(maxi2-1);
    }
}