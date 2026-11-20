class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        while(!map.isEmpty()){
            int first=map.firstKey();
            for(int i=0;i<k;i++){
                int num=first+i;
                if(!map.containsKey(num)){
                    return false;
                }
                int count=map.get(num);
                if(count==1){
                    map.remove(num);
                }else{
                    map.put(num,count-1);
                }
            }
        }
        return true;
    }
}