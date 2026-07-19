class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxi=Integer.MIN_VALUE;
        while(left<right){
            int m=right-left;
            int n=Math.min(height[right],height[left]);
            maxi=Math.max(maxi,n*m);
            if(n==height[left]){
                left++;
            }else{
                right--;
            }
        }
        return maxi;
    }
}