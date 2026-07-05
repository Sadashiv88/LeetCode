class Solution {
    public int numberOfSubstrings(String s) {
        int len=0;
        int left=0;
        int nums[]=new int [3];
        for(int right=0;right<s.length();right++){
            nums[s.charAt(right)-'a']++;

            while(nums[0]>0 && nums[1]>0 && nums[2]>0){
                len+=s.length()-right;
                nums[s.charAt(left)-'a']--;
                left++;
            }
        }
        return len;
        
    }
}