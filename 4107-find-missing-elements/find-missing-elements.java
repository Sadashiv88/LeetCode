class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<n;i++){
            mini=Math.min(nums[i],mini);
            maxi=Math.max(nums[i],maxi);
            h.add(nums[i]);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=mini;i<maxi;i++){
            if(!h.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}