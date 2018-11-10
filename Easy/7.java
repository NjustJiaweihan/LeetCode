class Solution
{
    private int[] num = new int[12];
    private int output = 0;
    //1 代表正数 0 代表负数
    private int flag = 1;
    public int reverse(int x)
    {
        if(x < 0)
        {
            flag = 0;
        }
        if(x == Integer.MIN_VALUE)
        {
            return 0;
        }
        //32位有符号正数范围：-2^31 ~ 2^31-1
        //Integer.MIN_VALUE 不能取 Math.abs 会溢出。
        x = Math.abs(x);
        if(x == 0)
        {
            return 0;
        }
        while(x % 10 == 0)
        {
            x = x / 10;
        }
        int i = 0;
        while (x != 0)
        {
            num[i] = x % 10;
            x = x / 10;
            i++;
        }

        for(int j=0; j<i; j++)
        {
            output =10 * output + num[j];
            //最后一次合成int不能再判断溢出了
            if(j == i-1)
            {
                break;
            }
            if(flag == 1)
            {
                if(output > Integer.MAX_VALUE/10 || ((output == Integer.MAX_VALUE/10) && num[i-1] > 7))
                {
                    return 0;
                }
            }
            else
            {
                //Integer.MAX 和 Integer.MIN 是不对称的
                if(output > Integer.MAX_VALUE/10 || ((output == Integer.MAX_VALUE/10) && num[i-1] > 8))
                {
                    return 0;
                }
            }
        }
        if(flag == 0)
        {
            output = 0 - output;
        }
        return output;
    }
}
