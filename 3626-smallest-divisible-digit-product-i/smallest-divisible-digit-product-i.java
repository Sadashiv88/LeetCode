class Solution {
    public int sum(int n){
        int sum=1;
        while(n>0){
            int t=n%10;
            n=n/10;
            sum=sum*t;
        }
        return sum;
    }
    public int smallestNumber(int n, int t) {
        int k=n;
        while(true){
            int s=sum(k);
            if(s==0) return k;
            if(s%t==0) return k;
            k++;
        }
        
    }
}