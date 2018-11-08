import java.util.HashMap;

class Solution
{
    public int[] numberOfLines(int[] widths, String S)
    {
        if(S.length()==0)
        {
            int[] output = {0,0};
            return output;
        }
        //每行长度
        int lineLength = 100;
        //行数
        int linesCount = 1;
        //行游标
        int count = 0;
        //返回值
        int[] output = new int[2];

        HashMap<String, Integer> wordnumTable = new HashMap<>(26);
        String[] word = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"
                , "l", "m", "n", "o", "p", "q", "r", "s"
                , "t", "u", "v", "w", "x", "y", "z"};
        for(int i=0; i<26; i++)
        {
            wordnumTable.put(word[i],i);
        }
        char[] c = S.toCharArray();
        for(int i=0; i<c.length; i++)
        {
            count += widths[wordnumTable.get(String.valueOf(c[i]))];
            if(count > lineLength)
            {
                count = widths[wordnumTable.get(String.valueOf(c[i]))];
                linesCount ++;
            }
        }
        output[0] = linesCount;
        output[1] = count;
        return output;
    }
}
