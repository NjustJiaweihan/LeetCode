class Solution
{
    public String toGoatLatin(String S)
    {
        String output;
        String[] word = S.split(" ");
        for(int i=0; i<word.length; i++)
        {
            if(word[i].charAt(0) == 'a'
                    || word[i].charAt(0) == 'e'
                    || word[i].charAt(0) == 'i'
                    || word[i].charAt(0) == 'o'
                    || word[i].charAt(0) == 'u'
                    || word[i].charAt(0) == 'A'
                    || word[i].charAt(0) == 'E'
                    || word[i].charAt(0) == 'I'
                    || word[i].charAt(0) == 'O'
                    || word[i].charAt(0) == 'U')
            {
                word[i] += "ma";
                for(int k=0; k<=i; k++)
                {
                    word[i] += "a";
                }
            }
            else
            {
                char c = word[i].charAt(0);
                word[i] = word[i].substring(1) + c;
                word[i] += "ma";
                for(int k=0; k<=i; k++)
                {
                    word[i] += "a";
                }
            }
        }
        output = word[0];
        for(int i=1; i<word.length; i++)
        {
            output += " "+word[i];
        }

        return output;
    }
}
