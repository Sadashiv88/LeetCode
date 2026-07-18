class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int arr[]=new int[2];
        for(int i=0;i<n;i++){
            int num=target-nums[i];
            if(map.containsKey(num)){
                arr[0]=map.get(num);
                arr[1]=i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return arr;
    }
}