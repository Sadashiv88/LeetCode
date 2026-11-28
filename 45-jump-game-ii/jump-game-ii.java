class Solution {
    public int jump(int[] nums) {
        int left=0;
        int fartest=0;
        int end=0;
        int jump=0;
       while(end<nums.length-1){
            
            for(int ii=left;ii<=end;ii++){
                fartest=Math.max(fartest,ii+nums[ii]);
            }
            jump+=1;
            left=end+1;
            end=fartest;
        }
        return jump;
    }
}