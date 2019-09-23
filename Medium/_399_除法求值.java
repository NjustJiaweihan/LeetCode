//package cn.deepblog.LeetCode;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class weightUF {

    public HashMap<Integer, Integer> id;
    public HashMap<Integer, Double> val;

    public int finds(int i){

        if(id.get(i) == i){
            return i;

        } else {

            int to = id.get(i);
            //递归找连通分量的root
            id.put(i, finds(to));
            //压缩路径
            val.put(i, val.get(i) * val.get(to));

            return id.get(i);
        }
    }
}

public class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        weightUF wuf = new weightUF();

        wuf.id = new HashMap<>();
        wuf.val = new HashMap<>();

        Map<String, Integer> map = new HashMap<>();

        int num = 0;

        List<Double> ans = new ArrayList<>();

        for(int i=0; i<equations.size(); i++){

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            if(!map.containsKey(a)){

                //字符串映射
                map.put(a, ++num);
                wuf.id.put(num, num);
                //val都初始化为1
                wuf.val.put(map.get(a), 1.0);
            }
            if(!map.containsKey(b)){

                //字符串映射
                map.put(b, ++num);
                wuf.id.put(num, num);
                //val都初始化为1
                wuf.val.put(map.get(b), 1.0);
            }
            //小的为父结点 a -values[i]-> b
            if(map.get(a) < map.get(b)){

                //将b的val设为values[i]
                wuf.val.put(map.get(b), values[i]);
                //b的父节点是a
                wuf.id.put(map.get(b), map.get(a));
                //寻找连通分量的root并压缩了路径
                wuf.id.put(map.get(b), wuf.finds(map.get(b)));

            } else {
                wuf.val.put(map.get(a), 1.0/values[i]);
                wuf.id.put(map.get(a), map.get(b));
                //寻找连通分量的root并压缩了路径
                wuf.id.put(map.get(a), wuf.finds(map.get(a)));
            }
        }

        for(int i=0; i<queries.size(); i++){

            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            if(!map.containsKey(a) || !map.containsKey(b)){

                ans.add(-1.0);
                continue;
            }
            //将a与b的id设为各自连通分量的root
            wuf.id.put(map.get(a), wuf.finds(map.get(a)));
            wuf.id.put(map.get(b), wuf.finds(map.get(b)));

            if(wuf.id.get(map.get(a)) != wuf.id.get(map.get(b))){
                ans.add(-1.0);
                continue;
            }
            double aa = wuf.val.get(map.get(a));
            double bb = wuf.val.get(map.get(b));
            ans.add(bb / aa);
        }

        double[] res = new double[ans.size()];
        int index = 0;
        for(double d : ans){
            res[index] = d;
            index++;
        }
        return res;
    }
}
