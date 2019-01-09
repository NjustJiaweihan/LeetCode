class Solution {
    public int[] intersection(int[] nums1, int[] nums2)
    {
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        for (int num1:nums1)
        {
            l1.add(num1);
        }
        for (int num2:nums2)
        {
            l2.add(num2);
        }
        Set<Integer> set1 = new HashSet<>(l1);
        Set<Integer> set2 = new HashSet<>(l2);
        Iterator iterator1 = set1.iterator();
        Iterator iterator2 = set2.iterator();

        int[] nums = new int[set1.size()+set2.size()];
        for(int i=0; i<set1.size(); i++)
        {
            nums[i] = (int) iterator1.next();
        }
        for(int i=set1.size(); i<nums.length; i++)
        {
            nums[i] = (int) iterator2.next();
        }
        Arrays.sort(nums);
        List<Integer> l3 = new LinkedList<Integer>();
        for (int i=0, j=0; i<nums.length; i++)
        {
            if(nums[i] == nums[i-1])
            {
                l3.add(nums[i]);
            }
        }
        int[] result = new int[l3.size()];
        Iterator iterator3 = l3.iterator();
        for(int i=0; i<result.length; i++)
        {
            result[i] = (int)iterator3.next();
        }
        return result;
    }
}
