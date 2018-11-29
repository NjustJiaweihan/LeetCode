class Solution
{
    //递归中的return一定是返回上一层方法调用 而不是直接结束方法!

    public TreeNode invertTree(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
