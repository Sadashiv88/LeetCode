class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int right=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        int maxi=0;

        while(right<n){
            char ch=s.charAt(right);
            if(mp.containsKey(ch)){
                left=Math.max(mp.get(ch)+1,left);
            }
            maxi=Math.max(maxi,right-left+1);
            mp.put(ch,right);
            right++;
        }
        return maxi;
    }
}