//从后往前排
//三目运算符 ？ ： 效率比if-else高
    
class Solution
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        //nums2游标
        int k = n-1;
        //nums1游标
        int j = m-1;
        int i = m+n-1;

        while (k>=0 && j>=0)
        {
            if(nums1[j]<nums2[k])
            {
                nums1[i] = nums2[k];
                i--;
                k--;
            }
            else
            {
                nums1[i] = nums1[j];
                i--;
                j--;
            }
        }
        if(k<0 && j>=0)
        {
            while (j>=0)
            {
                nums1[i] = nums1[j];
                i--;
                j--;
            }
        }
        else if(k>=0 && j<0)
        {
            while (k>=0)
            {
                nums1[i] = nums2[k];
                i--;
                k--;
            }
        }
    }
}
