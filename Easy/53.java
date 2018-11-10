class Solution
{
    //统计和 游标

    int localMax;
    //记录历史最大值

    int globalMax = Integer.MIN_VALUE;
    public int maxSubArray(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        for(int i=0; i<nums.length; i++)
        {
            localMax = Math.max(nums[i], localMax+nums[i]);
            //即sum < 0就抛弃
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
