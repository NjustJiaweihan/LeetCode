class Solution
{
    public void moveZeroes(int[] nums)
    {
        int i= 0;
        int count = nums.length;
        while (count > 0)
        {
            if(nums[i] == 0)
            {
                for(int j=i; j<nums.length-1; j++)
                {
                    nums[j] = nums[j+1];
                }
                nums[nums.length-1] = 0;
            }
            else
            {
                i++;
            }
            count--;
        }
    }
}
