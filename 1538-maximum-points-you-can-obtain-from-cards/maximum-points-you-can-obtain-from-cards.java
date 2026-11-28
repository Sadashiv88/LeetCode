class Solution {
    public int maxScore(int[] arr, int k) {
        int leftmost=0;
        int ans=0;
        for(int i=0;i<k;i++){
            leftmost+=arr[i];
        }
        ans=Math.max(leftmost,ans);
        int rightindex=arr.length-1;
        int rightmost=0;
        for(int i=k-1;i>=0;i--){
            leftmost-=arr[i];
            rightmost+=arr[rightindex];
            rightindex--;
            ans=Math.max(ans,rightmost+leftmost);

        }
        return ans;
    }
}