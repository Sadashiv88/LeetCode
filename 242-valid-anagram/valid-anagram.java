class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> mp1=new HashMap<>();
        if(t.length()!=s.length()) return false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mp.containsKey(ch)){
                int level=mp.get(ch);
                mp.put(ch,level+1);
            }else{
                 mp.put(ch,1);
            }
           
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(mp1.containsKey(ch)){
                int level=mp1.get(ch);
                mp1.put(ch,level+1);
            }
            else{
                mp1.put(ch,1);
            }
        }
        return mp1.equals(mp);
    }
}