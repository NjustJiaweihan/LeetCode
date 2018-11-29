//217
class Solution
{
    public boolean containsDuplicate(int[] nums)
    {
        if(nums.length == 0)
        {
            return false;
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++)
        {
            if(hs.contains(nums[i]))
            {
                return true;
            }
            else
            {
                hs.add(nums[i]);
            }
        }
        return false;
    }
}
