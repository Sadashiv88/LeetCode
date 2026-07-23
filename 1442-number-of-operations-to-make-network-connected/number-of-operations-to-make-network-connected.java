class DSU{
    int parent[];
    int size[];
    public DSU(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int findParent(int x){
        if(parent[x]==x){
            return x;
        }
        int ulx=findParent(parent[x]);
        parent[x]=ulx;
        return parent[x];
    }
    void union(int u,int v){
        int ulu=findParent(u);
        int ulx=findParent(v);

        if(ulu==ulx) return ;
        if(size[ulu]<size[ulx]){
            parent[ulu]=ulx;
            size[ulx]+=size[ulu];
        }else{
            parent[ulx]=ulu;
            size[ulu]+=size[ulx];
        }
    }
    int province(int sum){
        for(int i=0;i<size.length;i++){
            int ul=findParent(parent[i]);
            if(i==ul) sum++;
        }
        return sum;
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DSU dsu=new DSU(n);
        int cnt=0;
        for(int it[]:connections){
            int a=it[0];
            int b=it[1];
            int ua=dsu.findParent(a);
            int ub=dsu.findParent(b);
            
            if(ua==ub){
                cnt++;
            }else{
                dsu.union(a,b);
            }
        }
        int p=dsu.province(0);
        if(cnt>=p-1) return p-1;
        return -1;
    }
}