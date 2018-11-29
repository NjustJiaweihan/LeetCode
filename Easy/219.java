//219 只要有一对间距小于等于k的重复元素就可以了
class Solution
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i-1; j>=0; j--)
            {
                if(nums[i]==nums[j] && i-j <= k)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
