class Solution
{
    private int[] nums;
    public Solution(int[] nums)
    {
        this.nums = nums;
    }

    public int pick(int target)
    {
        Random r = new Random();
        int result = 0;
        int cnt = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == target)
            {
                cnt++;
                if(r.nextInt(cnt) == 0)
                {
                    result  = i;
                }
            }
        }
        return result;
    }
}
