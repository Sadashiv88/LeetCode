class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:tasks){
            map.put(num,map.getOrDefault(num,0)+1);

        }
        TreeMap<Integer,Integer> sorted=new TreeMap<>((a,b)->{
            int compare=map.get(a).compareTo(map.get(b));
            if(compare==0){
                return a.compareTo(b);
            }
            return compare;
        });
        sorted.putAll(map);
        int first=sorted.firstKey();
        if(map.get(first)==1) return -1;
        int count=0;
        while(!sorted.isEmpty()){
            int fir=sorted.firstKey();
            int c=sorted.get(fir);
            if(c==4){
                count++;
                count++;
                sorted.remove(fir);
            }else if(c==3){
                count++;
                sorted.remove(fir);
            }else if(c==2){
                count++;
                sorted.remove(fir);
            }
            else if(c==1){
                return -1;
            }else{
                count++;
                sorted.put(fir,c-3);
            }
            
        }
        return count;
    }
}