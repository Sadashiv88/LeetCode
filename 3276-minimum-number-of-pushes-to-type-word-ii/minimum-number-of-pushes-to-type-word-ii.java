class Solution {
    class pair{
        int first;
        int second;
        pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    public int minimumPushes(String word) {
        int n=word.length();
        int vis[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            int index=ch-'a';
            vis[index]++;
        }
        List<pair> p=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(vis[i]!=0){
                p.add(new pair(i,vis[i]));
            }
        }
        Collections.sort(p,(a,b)->b.second-a.second);
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        if(p.size()<=8){
            for(int i=0;i<p.size();i++){
                a+=p.get(i).second;
            }

        }else if(p.size()>8 && p.size()<=16){
            for(int i=0;i<8;i++){
                a+=p.get(i).second;
            }
            for(int i=8;i<p.size();i++){
                b+=p.get(i).second *2;
            }
        }else if(p.size()>=16 && p.size()<24){
            for(int i=0;i<8;i++){
                a+=p.get(i).second;
            }
            for(int i=8;i<16;i++){
                b+=p.get(i).second *2;
            }
            for(int i=16;i<p.size();i++){
                c+=p.get(i).second*3;
            }
        }else{
            for(int i=0;i<8;i++){
                a+=p.get(i).second;
            }
            for(int i=8;i<16;i++){
                b+=p.get(i).second *2;
            }
            for(int i=16;i<24;i++){
                c+=p.get(i).second*3;
            }
            for(int i=24;i<p.size();i++){
                d+=p.get(i).second*4;
            }
        }
        return a+b+c+d;
    }
}