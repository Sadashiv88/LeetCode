class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        if(word.length()<=8){
            return word.length();
        }else if(n>=9 && n<=16){
            int t=n-8;
            t=t*2;
            return t+8;
        }else if(n>=17 && n<=24){
            int t=16;
            
            int p=n-16;
            p=3*p;
            return p+t+8;
        }else{
             int t=16;
           
            int p=24;
           
            int q=n-24;
            q=q*4;
            return p+t+8+q;
        }
    }
}