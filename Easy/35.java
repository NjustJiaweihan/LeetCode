class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null)
        {
            return -1;
        }
        if(nums.length == 0)
        {
            return 0;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mid = -1;
        while(lo <= hi)
        {
            mid = lo + (hi - lo) / 2;
            if(target < nums[mid])
            {
                hi = mid - 1;
            }
            else if(target > nums[mid])
            {
                lo = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        if(hi == mid)
        {
            return mid + 1;
        }
        else
        {
            return mid;
        }
    }
}
