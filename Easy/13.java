class Solution
{
    private char[] roman;
    private int num;
    //采用HashMap 时耗大 但稍微好维护一些
    
    private HashMap<String, Integer> RomanNum;
    public Solution()
    {
        num = 0;
        RomanNum = new HashMap<>();
        RomanNum.put("I",1);
        RomanNum.put("V",5);
        RomanNum.put("X",10);
        RomanNum.put("L",50);
        RomanNum.put("C",100);
        RomanNum.put("D",500);
        RomanNum.put("M",1000);
    }
    public int romanToInt(String s)
    {
        //非空判断
        if(s.length() == 0)
        {
            return 0;
        }

        roman = s.toCharArray();

        for(int i=0; i<roman.length; i++)
        {
            //数组索引边界判断
            if(i == roman.length-1)
            {
                num += RomanNum.get(roman[i] + "");
                break;
            }
            if(roman[i] == 'I' && roman[i+1] == 'V')
            {
                num += 4;
                i++;
            }
            else if(roman[i] == 'I' && roman[i+1] == 'X')
            {
                num += 9;
                i++;
            }
            else if(roman[i] == 'X' && roman[i+1] == 'L')
            {
                num += 40;
                i++;
            }
            else if(roman[i] == 'X' && roman[i+1] == 'C')
            {
                num += 90;
                i++;
            }
            else if(roman[i] == 'C' && roman[i+1] == 'D')
            {
                num += 400;
                i++;
            }
            else if(roman[i] == 'C' && roman[i+1] == 'M')
            {
                num += 900;
                i++;
            }
            else
            {
                num += RomanNum.get(roman[i] + "");
            }
        }
        return num;
    }
}
