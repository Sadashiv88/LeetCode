class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxi=1;
        int left=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                left=i;
            }
            maxi=Math.max(maxi,i-left+1);
        }
        return maxi;
    }
}