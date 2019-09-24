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

public class Solution {

    public int regionsBySlashes(String[] grid) {

        if(grid == null || grid.length == 0){
            return 0;
        }

        int N = grid.length;

        //给个格子分为四个小三角形 上下左右分别标号为: 0 2 3 1
        UF uf = new UF(4 * N * N);

        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){

                int index = 4 * (i * N + j);
                char c = grid[i].charAt(j);
                if(c == '/'){

                    uf.connect(index, index+3);
                    uf.connect(index+1,index+2 );
                }
                if(c == '\\'){
                    uf.connect(index, index+1);
                    uf.connect(index+2, index+3);
                }
                if(c == ' '){
                    uf.connect(index, index+1);
                    uf.connect(index+1, index+2);
                    uf.connect(index+2, index+3);
                }

                //上下
                if(i > 0){
                    
                    //格子(i, j)的0号位与格子(i-1, j)的2号位
                    uf.connect(index, index-(N-1)*4-2);
                }
                
                //左右
                if(j > 0){
                    //格子(i, j)的3号位与格子(i, j-1)的1号位
                    uf.connect(index+3, index-3);
                }
            }
        }
        return uf.count;
    }
}
