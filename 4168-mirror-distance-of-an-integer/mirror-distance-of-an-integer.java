class Solution {
    public int reverse(int n){
        int sum=0;
        while(n>0){
            int t=n%10;
            n=n/10;
            sum=sum*10+t;
        }
        return sum;
    }
    public int mirrorDistance(int n) {
        int d=reverse(n);
        return Math.abs(n-d);
    }
}