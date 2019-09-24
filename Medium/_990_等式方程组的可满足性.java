//package cn.deepblog.LeetCode;

import java.util.HashMap;

class UF{

    public int[] id;
    public int[] sz;
    public boolean[] marked;
    public int count;

    public UF(int N){

        count = N;
        id = new int[N];
        sz = new int[N];
        marked = new boolean[N];

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

    public boolean equationsPossible(String[] equations) {

        int N = equations.length;
        UF uf = new UF(N * 2);

        //给字母做整数索引映射
        HashMap<Character, Integer> word2int = new HashMap<>();
        int num = -1;

        for(int i=0; i<N; i++){

            char c1 = equations[i].charAt(0);
            char c2 = equations[i].charAt(3);
            
            if(!word2int.containsKey(c1)){
                word2int.put(c1, ++num);
            }
            if(!word2int.containsKey(c2)){
                word2int.put(c2, ++num);
            }
        }
        
        //用等式预处理连通分量
        for(int i=0; i<N; i++){
            
            if(equations[i].charAt(1) == '='){
                
                char c1 = equations[i].charAt(0);
                char c2 = equations[i].charAt(3);
                
                int index1 = word2int.get(c1);
                int index2 = word2int.get(c2);
                
                uf.connect(index1, index2);
            }
        }
        
        //检验所有不等式
        for(int i=0; i<N; i++){

            if(equations[i].charAt(1) == '!'){

                char c1 = equations[i].charAt(0);
                char c2 = equations[i].charAt(3);

                int index1 = word2int.get(c1);
                int index2 = word2int.get(c2);

                if(uf.connected(index1, index2)){
                    return false;
                }
            }
        }
        return true;
    }

    /*
    public static void main(String[] args) {

        _990_等式方程的可满足性 s = new _990_等式方程的可满足性();

        String[] e = {"c==c","f!=a","f==b","b==c"};

        System.out.println(s.equationsPossible(e));
    }
    */
}

