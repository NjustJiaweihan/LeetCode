class Solution {
    public String[] uncommonFromSentences(String A, String B) {

        HashMap<String, Integer> cnt = new HashMap<>();

        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");

        for(int i=0; i<wordsA.length; ++i) {

            if(cnt.containsKey(wordsA[i])) {

                cnt.put(wordsA[i], cnt.get(wordsA[i])+1);
            } else {

                cnt.put(wordsA[i], 1);
            }
        }

        for(int i=0; i<wordsB.length; ++i) {

            if(cnt.containsKey(wordsB[i])) {

                cnt.put(wordsB[i], cnt.get(wordsB[i])+1);
            } else {

                cnt.put(wordsB[i], 1);
            }
        }
        
        //值得学习的写法

//        List<String> list=new ArrayList();
        
//        for(Map.Entry<String,Integer> entry:map.entrySet()){
//            if(entry.getValue()<2){
//                list.add(entry.getKey());
//            }
//        }
        
//        return list.toArray(new String[list.size()]);
        
        ArrayList<String> res = new ArrayList<>();

        Iterator i = cnt.entrySet().iterator();

        while (i.hasNext()) {

            Map.Entry entry = (Map.Entry) i.next();

            if(entry.getValue() == (Integer) 1) {

                res.add(entry.getKey().toString());
            }
        }

        String[] result = new String[res.size()];

        int index = 0;
        for(String s : res) {

            result[index] = s;
            index++;
        }

        return result;
    }
}


//贴一个老哥的优雅代码
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }
}

