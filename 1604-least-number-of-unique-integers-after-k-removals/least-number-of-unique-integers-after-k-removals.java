class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        TreeMap<Integer, Integer> sorted =
    new TreeMap<>((a, b) -> {
        int compare = map.get(a).compareTo(map.get(b));

        if (compare == 0) {
            return a.compareTo(b);
        }

        return compare;
    });

    sorted.putAll(map);

        
        for(int i=0;i<k;i++){
            int first=sorted.firstKey();
            if(sorted.get(first)==1){
                sorted.remove(first);
            }else{
                sorted.put(first,sorted.get(first)-1);
            }
        }
        int count=0;
        for(int num:sorted.keySet()){
            count++;
        }
        return count;
    }
}