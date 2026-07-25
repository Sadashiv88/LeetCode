class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi=0;
        for(int i=0;i<piles.length;i++){
            maxi=Math.max(piles[i],maxi);
        }
        int start=0;
        int end=maxi;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(possible(mid,piles,h)){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }

        }
        return ans;
        
    }
     public boolean possible(int mid,int []a,int h){
            int total=0;
            for(int i=0;i<a.length;i++){
                total+=Math.ceil((double)a[i]/(double)mid);
            }
            return total<=h;
        }
   
}