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
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DSU dsu=new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    dsu.union(i,j);
                }
            }
        }
        int cnt=0;
        return dsu.province(cnt);
        
    }
}