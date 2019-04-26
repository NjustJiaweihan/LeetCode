//和二叉树最大深度还是有点区别的
class Solution
{
    public int minDepth(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        return min(root);
    }

    private int min(TreeNode root)
    {
        //为了应对最大根结点无左子树或右子树时结果返回1的情况
        //因为只有此情况会到达(root == null)
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }

        //叶子结点止步于此 不会进入(root == null)的判断
        if(root.left == null && root.right == null)
        {
            return 1;
        }

        int left = min(root.left);
        int right = min(root.right);

        return Math.min(left, right) + 1;
    }
}
