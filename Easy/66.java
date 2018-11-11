//考虑9,99

class Solution
{
    public int[] plusOne(int[] digits)
    {
        int[] forNine = {1,0};
        int[] digitsPlus = new int[digits.length];
        int[] digitsPlusPlus = new int[digits.length+1];
        //进位标志 0：没有进位
        int CF = 0;
        if(digits.length ==1 && digits[0] == 9)
        {
            return forNine;
        }

        digitsPlus[digits.length-1] = digits[digits.length-1] + 1;
        if(digitsPlus[digits.length-1] >= 10)
        {
            digitsPlus[digits.length-1] -= 10;
            CF = 1;
        }
        //length-2 数组长度至少为2 所以单独考虑[9]
        for(int i=digits.length-2; i>=0; i--)
        {
            digitsPlus[i] = digits[i] + CF;
            //进位标志记得清零
            CF = 0;
            if(digitsPlus[i] >= 10)
            {
                if(i == 0)
                {
                    digitsPlus[i] -= 10;
                    for(int j=1; j<digitsPlusPlus.length; j++)
                    {
                        digitsPlusPlus[j] = digitsPlus[j-1];
                    }
                    digitsPlusPlus[0] = 1;
                    return digitsPlusPlus;
                }
                digitsPlus[i] -= 10;
                CF = 1;
            }
        }
        return digitsPlus;
    }
}
