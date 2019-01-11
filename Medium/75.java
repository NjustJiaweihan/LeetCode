//计数排序
class Solution
{
    public void sortColors(int[] nums)
    {
        //统计
        int[] count = {0,0,0};
        for(int i=0; i<nums.length; i++)
        {
            count[ nums[i] ]++;
        }
        //重构
        int j = 0;
        for(int i=0; i<count.length; i++)
        {
            while (count[i] != 0)
            {
                nums[j++] = i;
                count[i]--;
            }
        }
    }
}

//75 仅使用常数空间的一趟扫描算法
//遇到0 往数组头插 遇到2 往数组尾插
class Solution
{

    public void sortColors(int[] nums)
    {
        int i = 0;
        int count = 1;
        while (count <= nums.length)
        {
            if(nums[i] == 0)
            {
                if(i != 0)
                {
                    insertHead(nums, i);
                }
                else
                {
                    i++;
                }
            }
            else if(nums[i] == 2)
            {
                insertTail(nums, i);
            }
            else
            {
                i++;
            }
            count++;
        }
    }
    private void insertHead(int[] nums, int v)
    {
        for(int i=v; i>0; i--)
        {
            nums[i] = nums[i-1];
        }
        nums[0] = 0;
    }
    private void insertTail(int[] nums, int v)
    {
        for(int i=v; i<nums.length-1; i++)
        {
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = 2;
    }
}
