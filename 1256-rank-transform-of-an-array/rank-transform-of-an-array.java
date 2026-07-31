class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashSet<Integer> h=new HashSet<>();
        for(int it:arr){
            h.add(it);
        }
        List<Integer> list=new ArrayList<>(h);
        Collections.sort(list);
        HashMap<Integer,Integer> mp=new HashMap<>();
        int timer=1;
        for(int it:list){
            mp.put(it,timer);
            timer++;
        }
        int []arr1=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            arr1[i]=mp.get(arr[i]);
        }
        return arr1;

    }
}