class Solution
{
    public int[] intersect(int[] nums1, int[] nums2) {
        int max = Math.min(nums1.length, nums2.length);
        ArrayList result = new ArrayList();
        int index = 0;

        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {
                if (nums1[i] == nums2[j])
                {
                    result.add(nums1[i]);
                    nums2[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        int[] r = new int[result.size()];
        Iterator iterator = result.iterator();
        for (int i = 0; i < r.length; i++)
        {
            r[i] = (int)iterator.next();
        }
        return r;
    }
}
