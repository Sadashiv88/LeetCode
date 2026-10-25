class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Character> q=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));

        q.addAll(map.keySet());

        StringBuilder st=new StringBuilder();
        while(!q.isEmpty()){
            char ch=q.poll();
            for(int i=0;i<map.get(ch);i++){
                st.append(ch);
            }
        }
        return st.toString();
    }
}