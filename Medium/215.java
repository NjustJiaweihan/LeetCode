class Solution
{
    public int findKthLargest(int[] a, int k)
    {
        int N = a.length;
        int lo =0;
        int hi = a.length-1;

        while (lo < hi)
        {
            int j = partition(a, lo, hi);
            if(j == k-1)
            {
                return a[j];
            }
            else if(j < k-1)
            {
                lo = j+1;
            }
            else
            {
                hi = j-1;
            }
        }
        //找到中位数的情况有两种：
        //直接j == k
        //切无可切,单元素,也就是a[j],也是a[k]  因为j是奔着k去的
        return a[k-1];
    }
    private int partition(int[] a, int lo, int hi)
    {
        int i = lo;
        int j = hi+1;
        int v = a[lo];
        while (true)
        {
            while (a[++i] > v)
            {
                if(i == hi)
                {
                    break;
                }
            }
            while (a[--j] < v)
            {
                if(j == lo)
                {
                    break;
                }
            }
            if(i >= j)
            {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private void exch(int[] a, int v, int w)
    {
        int temp = a[v];
        a[v] = a[w];
        a[w] = temp;
    }
}
