class Solution
{
    public int[] sortArrayByParityII(int[] A) {
        //偶数寻找指针
        int i = 0;
        //奇数寻找指针
        int j = 0;
        int k = 0;
        int[] result = new int[A.length];
        while (k < A.length)
        {
            if (k % 2 == 0)
            {
                while (A[i] % 2 != 0)
                {
                    i++;
                }
                result[k] = A[i];
                i++;
                k++;
            }
            else
            {
                while (A[j] % 2 == 0)
                {
                    j++;
                }
                result[k] = A[j];
                j++;
                k++;
            }
        }
        return result;
    }
}
