class Solution {
    public int findMin(int[] nums) {
        int st=0;
        int end=nums.length-1;
        int ans=0;
        int n=nums.length;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]<=nums[n-1]){
                ans=mid;
                end=mid-1;
            }else{
                st=mid+1;
            }
        }
        return nums[ans];
    }
}