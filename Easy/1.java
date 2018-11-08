class Solution
{
    int[] output = new int[2];
    public int[] twoSum(int[] nums, int target)
    {
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                if((nums[i] + nums[j]) == target)
                {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        return output;
    }
}
