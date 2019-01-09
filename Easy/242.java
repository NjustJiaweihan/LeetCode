class Solution
{
    public boolean isAnagram(String s, String t)
    {
        if(s.length() == 0 && t.length() != 0)
        {
            return false;
        }
        if(t.length() == 0 && s.length() != 0)
        {
            return false;
        }
        if(s.length() != t.length())
        {
            return false;
        }
        char[] ss = s.toCharArray();
        Arrays.sort(ss);


        char[] tt = t.toCharArray();
        Arrays.sort(tt);

        for(int i=0; i<t.length(); i++)
        {
            if(tt[i] != ss[i])
            {
                return false;
            }
        }
        return true;
    }
}
