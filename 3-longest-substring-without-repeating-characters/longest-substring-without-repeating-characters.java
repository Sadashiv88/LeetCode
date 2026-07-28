class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int right=0;
        int len=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        while(right<n){
            char ch=s.charAt(right);
            if(mp.containsKey(ch)){
                left=Math.max(mp.get(ch)+1,left);
            }
            len=Math.max(len,right-left+1);
            mp.put(ch,right);
            right++;

        }
        return len;
    }
}