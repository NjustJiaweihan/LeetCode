//package cn.deepblog.LeetCode;

class UF{

    public int[] id;
    public int[] sz;
    public int count;

    public UF(int N){

        count = N;
        id = new int[N];
        sz = new int[N];

        for(int i=0; i<N; i++){

            sz[i] = 1;
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){

        return find(p) == find(q);
    }

    public int find(int i){

        //连通分量的root满足 i=id[i]
        while (i != id[i]){

            //根据i的val: id[i]作为新索引找到下一个元素id[id[i]]
            //并将i的val更新为该元素的索引
            id[i] = id[id[i]];
            //再从下一个元素开始找 直到找到root
            i = id[i];
        }
        return i;
    }

    public void connect(int p, int q){

        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }

        //小连通分量往大连通分量上并
        if(sz[i] < sz[j]){

            id[i] = j;
            sz[j] += sz[i];

        } else {

            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }
}

class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        if(edges == null || edges.length == 0 || edges[0].length == 0){
            
            return null;
        }
        
        int numOfEdge = edges.length;
        int N = 0;
        
        for(int i=0; i<numOfEdge; i++){
            
            for(int j=0; j<2; j++){
                
                if(edges[i][j] > N){
                    
                    N = edges[i][j];
                }
            }
        }
        
        //0 ～ N 0不使用
        UF uf = new UF(N+1);

        int toDel = 0;
        for(int i=0; i<numOfEdge; i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(uf.connected(u, v)){
                
                toDel = i;
            } else {
                
                uf.connect(u, v);
            }
        }
        
        return edges[toDel];
    }
}
