class Solution {
    public int jump(int[] nums) {
        int l=0;
        int r=0;
        int jump=0;
        int fartest=0;
        while(r<nums.length-1){
            for(int i=l;i<=r;i++){
                fartest=Math.max(fartest,i+nums[i]);
            }
            l=r+1;
            r=fartest;
            jump=jump+1;
        }
        return jump++;
    }
}