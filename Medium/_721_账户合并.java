package cn.deepblog.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

public class _721_账户合并 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        if(accounts == null){
            return null;
        }

        int N = accounts.size();
        //最多有accounts.size()个连通分量
        UF uf = new UF(N);

        //key: email value: accountID
        HashMap<String, Integer> email2account = new HashMap<>();

        //计算连通分量
        for(int i=0; i<N; i++){

            for(int j=1; j<accounts.get(i).size(); j++){

                String email = accounts.get(i).get(j);

                if(email2account.containsKey(email)){
                    //i: email的accountID 
                    //uf.find(email2account.get(email)): 已经在map中的同名email的连通分量root的accountID
                    uf.connect(i, uf.find(email2account.get(email)));

                } else {
                    email2account.put(email, i);
                }
            }
        }

        //构造结果集
        List<List<String>> res = new ArrayList<>();

        //1.邮箱合并同类项
        HashMap<Integer, HashSet<String>> unionEmails = new HashMap<>();
        for(int i=0; i<N; i++){

            int root = uf.find(i);
            if(!unionEmails.containsKey(root)){
                //没有 构建HashSet
                HashSet<String> temp = new HashSet<String>();
                for(int j=1; j<accounts.get(i).size(); j++){
                    temp.add(accounts.get(i).get(j));
                }
                unionEmails.put(root, temp);

            } else {
                //有 直接在HashSet上添加
                for(int j=1; j<accounts.get(i).size(); j++){
                    unionEmails.get(root).add(accounts.get(i).get(j));
                }
            }
        }

        //2.accountID -> name
        for(Integer accountID : unionEmails.keySet()){

            String name = accounts.get(accountID).get(0);

            List<String> temp = new ArrayList<>();

            temp.add(name);
            //排序
            List<String> emails = new ArrayList<>(unionEmails.get(accountID));
            Collections.sort(emails);
            temp.addAll(emails);

            res.add(temp);
        }

        return res;
    }

    /**
     * [["John","johnsmith@mail.com","john_newyork@mail.com"],
     * ["John","johnsmith@mail.com","john00@mail.com"],
     * ["Mary","mary@mail.com"],
     * ["John","johnnybravo@mail.com"]]
     *
     * [["David","David0@m.co","David4@m.co","David3@m.co"],
     * ["David","David5@m.co","David5@m.co","David0@m.co"],
     * ["David","David1@m.co","David4@m.co","David0@m.co"],
     * ["David","David0@m.co","David1@m.co","David3@m.co"],
     * ["David","David4@m.co","David1@m.co","David3@m.co"]]
     * @param args
     */
    public static void main(String[] args) {

        _721_账户合并 s = new _721_账户合并();

        List<String> l1 = new ArrayList<String>(){{
            add("David");
            add("David0@m.co");
            add("David4@m.co");
            add("David3@m.co");
        }};
        List<String> l2 = new ArrayList<String>(){{
            add("David");
            add("David5@m.co");
            add("David5@m.co");
            add("David0@m.co");
        }};
        List<String> l3 = new ArrayList<String>(){{
            add("David");
            add("David1@m.co");
            add("David4@m.co");
            add("David0@m.co");
        }};
        List<String> l4 = new ArrayList<String>(){{
            add("David");
            add("David0@m.co");
            add("David1@m.co");
            add("David3@m.co");
        }};
        List<String> l5 = new ArrayList<String>(){{
            add("David");
            add("David4@m.co");
            add("David1@m.co");
            add("David3@m.co");
        }};

        List<List<String>> accounts = new ArrayList<List<String>>(){{

            add(l1);
            add(l2);
            add(l3);
            add(l4);
            add(l5);
        }};

        List<List<String>> res = s.accountsMerge(accounts);
        System.out.println(res);
    }
}
