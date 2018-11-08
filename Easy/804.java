class Solution
{
    public String[] uniqueMorseRepresentations(String[] words)
    {
        if(words.length == 0)
        {
            return null;
        }
        HashMap<String, String> MorseWordTable = new HashMap<>(26);
        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "...."
                //abcdefgh
                , "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-"
                //ijklmnopq
                , ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
                //rstuvwxyz
        String[] word = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"
                , "l", "m", "n", "o", "p", "q", "r", "s"
                , "t", "u", "v", "w", "x", "y", "z"};
        for (int i = 0; i < 26; i++)
        {
            MorseWordTable.put(word[i], code[i]);
        }

        String[] MorseWord = new String[words.length];

        for (int i = 0; i < words.length; i++)
        {
            char[] temp = words[i].toCharArray();
            for (int j = 0; j < temp.length; j++)
            {
                MorseWord[i] += MorseWordTable.get(String.valueOf(temp[j]));
            }
        }

        Arrays.sort(MorseWord);
        int count = 0;
        int i = 0;
        //两个索引，一个快一个慢，一个探路，另一个在前一个遇到不同元素时跟上
        for (int j = 0; j < MorseWord.length; j++)
        {
            if (!MorseWord[i].equals(MorseWord[j]))
            {
                i = j;
                count++;
            }
        }
        return MorseWord;
    }
}
