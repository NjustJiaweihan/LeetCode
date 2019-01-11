class Solution
{
    public List<Integer> pancakeSort(int[] A)
    {
        int N = A.length;
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while (count < N)
        {
            int max = A[0];
            int index = 0;

            for(int j=1; j<=N-count; j++)
            {
                if(A[j] > max)
                {
                    max = A[j];
                    index = j;
                }
            }

            list.add(index+1);
            pancakeOpt(A, index);
            list.add(N-count+1);
            pancakeOpt(A, N-count);
            count++;
        }
        return list;
    }
    private void pancakeOpt(int[] A, int t)
    {
        int i = 0;
        int j = t;
        int temp;
        while (i < j)
        {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}
