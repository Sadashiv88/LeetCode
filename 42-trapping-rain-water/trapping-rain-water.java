class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int premax[]=new int[n];
        int postmax[]=new int[n];
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            premax[i]=Math.max(maxi,height[i]);
            maxi=premax[i];
        }
        maxi=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            postmax[i]=Math.max(maxi,height[i]);
            maxi=postmax[i];
        }
        int total=0;
        for(int i=0;i<n;i++){
            if(premax[i]>height[i] && postmax[i]>height[i]){
                total+=Math.min(premax[i],postmax[i])-height[i];
            }
        }
        return total;
    }
}