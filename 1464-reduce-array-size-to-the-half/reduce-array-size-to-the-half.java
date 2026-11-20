class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        TreeMap<Integer,Integer> sorted=new TreeMap<>((a,b)->{
            int compare=map.get(b).compareTo(map.get(a));
            if(compare==0){
                return b.compareTo(a);
            }
            return compare;
        });
        sorted.putAll(map);
        int n=arr.length/2;
        int count=0;
        while(n>0){
            int first=sorted.firstKey();
            n=n-sorted.get(first);
            count++;
            sorted.remove(first);
        }
        return count;
    }
}