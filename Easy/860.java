//给20找零 优先用10块的
class Solution
{
    private int[] Count;
    //Count[0]:5 Count[1]:10 Count[2]:20

    public Solution()
    {
        Count = new int[3];
    }
    public boolean lemonadeChange(int[] bills)
    {
        for(int i=0; i<bills.length; i++)
        {
            if(bills[i] == 5)
            {
                Count[0] ++;
            }
            else if(bills[i] == 10)
            {
                Count[1] ++;
                if(Count[0] >= 1)
                {
                    Count[0]--;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                Count[2] ++;
                if(Count[0] >=1 && Count[1] >=1)
                {
                    Count[0]--;
                    Count[1]--;
                }
                else if (Count[0] >=3)
                {
                    Count[0] = Count[0] - 3;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}
