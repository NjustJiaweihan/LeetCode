//int的拆分平方和 < 9^2 * 10 = 810
//最多810个拆分平方和的计算 不会无限循环 
//因此导致无限循环的一定是出现了重复数字 进入了死循环

//取int中的每一位 只需要用"%10"再"/10"就好了呀！

class Solution
{
    public boolean isHappy(int n)
    {
        //元素不可重复
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        //2^31-1 最多10位
        int[] c = new int[10];
        //记录拆分平方和结果位数
        int i = 0;
        while (n != 0)
        {
            c[i] = n % 10;
            n = n / 10;
            i++;
        }
        while (sum != 1)
        {
            sum = 0;
            for(int j=0; j<i; j++)
            {
                sum += c[j] * c[j];
            }
            if(hashSet.contains(sum))
            {
                return false;
            }
            hashSet.add(sum);
            i = 0;
            n = sum;
            while (n != 0)
            {
                c[i] = n%10;
                n = n / 10;
                i++;
            }
        }
        return true;
    }
}
