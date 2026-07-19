class Solution {
    public int characterReplacement(String s, int k) {
        int maxi=Integer.MIN_VALUE;
        int maxi1=Integer.MIN_VALUE;
        HashMap<Character,Integer> mp=new HashMap<>();
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            mp.put(ch,mp.getOrDefault(ch, 0) + 1);
            maxi=Math.max(maxi,mp.get(ch));
            while((right-left+1)-maxi>k){
                char ch1=s.charAt(left);
                int level=mp.get(ch1);
                mp.put(ch1,level-1);
                if(mp.get(ch1)==0){
                    mp.remove(ch1);
                }
                left++;
            }
            maxi1=Math.max(maxi1,right-left+1);

        }
        return maxi1;
    }
}