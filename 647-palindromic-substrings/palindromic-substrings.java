class Solution {
    public boolean isPalindromic(String s){
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(isPalindromic(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }
}