class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0;
        int maxi=0;
        for(int right=0;right<nums.length;right++){
            // map.put(nums[right],map.getOrDefault(0,right)+1);
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            int c=map.get(nums[right]);
            while(c>k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
                c=map.get(nums[right]);
            }
            maxi=Math.max(maxi,right-left+1);
        }
        return maxi;
    }
}