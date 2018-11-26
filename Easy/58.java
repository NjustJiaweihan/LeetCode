class Solution {
    public int lengthOfLastWord(String s)
    {
        //空串判断
        if(s.length() == 0)
        {
            return 0;
        }
        char[] words = s.toCharArray();
        int count = 0;
        //start = true 表示开始计算最后一个单词长度
        boolean start = false;
        for(int i=words.length-1; i>=0; i--)
        {
            if(words[i] == ' ' && start == false)
            {
                continue;
            }
            else if(words[i] == ' ' && start == true)
            {
                break;
            }
            else
            {
                start = true;
                count++;
            }
        }
        return count;
    }
}
