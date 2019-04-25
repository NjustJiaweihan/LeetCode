class Solution 
{
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        if (nums == null) 
        {
            return null;
        }

        return convertTree(nums, 0, nums.length - 1);
    
    }

    private TreeNode convertTree(int[] nums, int lo, int hi) 
    {
        if (lo > hi) 
        {
            return null;
        }

        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convertTree(nums, lo, mid - 1);
        root.right = convertTree(nums, mid + 1, hi);
        return root;
    }
}
