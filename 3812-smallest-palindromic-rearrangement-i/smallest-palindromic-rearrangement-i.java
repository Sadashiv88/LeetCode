class Solution {
    String t="";
    public boolean isPalindrome(String s){
        int start=0;
        int end=s.length()-1;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void helper(String s,int n,boolean vis[],StringBuilder curr){
        if(n==s.length()){
            if(t.compareTo(curr.toString())==1 && isPalindrome(curr.toString())){
                t=curr.toString();
            }
            if (isPalindrome(curr.toString()) && t.compareTo(curr.toString()) > 0) {
                t = curr.toString();
            }
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!vis[i]){
                vis[i]=true;
                curr.append(s.charAt(i));
                helper(s,n+1,vis,curr);
                vis[i]=false;
                curr.deleteCharAt(curr.length()-1);

            }
        }
    }
    public String smallestPalindrome(String s) {
        // int  n=s.length();
        // t=s;
        // boolean vis[]=new boolean[n];
        // helper(s,0,vis,new StringBuilder());
        // return t;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            while (freq[i] >= 2) {
                left.append((char) ('a' + i));
                freq[i] -= 2;
            }

            if (freq[i] == 1) {
                mid.append((char) ('a' + i));
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        return left.toString() + mid.toString() + right.toString();
    }
}