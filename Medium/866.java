class Solution
{
    private char[] numbers;
    private int output;
    public int primePalindrome(int N)
    {
        //如何快速寻找下一个数
        for(int i=N; i<Integer.MAX_VALUE; i++)
        {
            if(isPrime(i) && isPalindrome(i))
            {
                output = i;
                break;
            }
        }
        return output;
    }
    private boolean isPrime(int N)
    {
        if(N <= 1)
        {
            return false;
        }
        if(N == 2)
        {
            return true;
        }
        //去除偶数的判断
        if(N % 2 == 0)
        {
            return false;
        }
        //定理：如果n不是素数，则n有满足1<d<=sqrt(n)的一个因子d
        for(int i=3; i*i<=N; i+=2)
        {
            if(N % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    private boolean isPalindrome(int N)
    {
        numbers = String.valueOf(N).toCharArray();
        for(int i=0; i<numbers.length/2; i++)
        {
            if(numbers[i] != numbers[numbers.length-1-i])
            {
                return false;
            }
        }
        return true;
    }
}
