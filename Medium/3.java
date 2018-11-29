class Solution
{
    public int lengthOfLongestSubstring(String s)
    {
        if(s.equals(""))
        {
            return 0;
        }
        if(s.length() == 1)
        {
            return 1;
        }
        LinkedList<String> q = new LinkedList<>();
        int maxCount = 0;
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(q.contains(""+s.charAt(i)))
            {
                if(maxCount < count)
                {
                    maxCount = count;
                }
                q.poll();
                i--;
                count--;
            }
            else
            {
                q.offer(""+s.charAt(i));
                count++;
            }
        }
        return Math.max(maxCount,count);
    }
}
