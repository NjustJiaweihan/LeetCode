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

public class _200_岛屿数量 {

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0){

            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        UF uf = new UF(row * col + 1);

        for(int i=0; i<row; i++){

            for(int j=0; j<col; j++){

                if(grid[i][j] == '1'){

                    if(i+1<row && grid[i+1][j] == '1'){
                        uf.connect(i * col + j, (i+1) * col + j);
                    }

                    if(j+1<col && grid[i][j+1] == '1'){
                        uf.connect(i * col + j, i * col + j + 1);
                    }

                } else {

                    uf.connect(i * col + j, row * col);
                }
            }
        }
        return uf.count - 1;
    }

    /*
    public static void main(String[] args) {

        _200_岛屿数量 s = new _200_岛屿数量();

        char[][] c = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(s.numIslands(c));
    }
    */
}
