class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int low=prices[0];
        int high=0;
        for(int i=1;i<n;i++){
            low=Math.min(low,prices[i]);
            high=Math.max(high,prices[i]-low);
        }
        return high;
    }
    // public int maxProfit(int[] prices) {
    //     int n=prices.length;
    //     int mini=prices[0];
    //     int maxProfit=0;
    //     for(int i=1;i<n;i++){
    //         int cost=prices[i]-mini;
    //         maxProfit=Math.max(maxProfit,cost);
    //         mini=Math.min(prices[i],mini);
    //     }
    //     return maxProfit;
    // }
}