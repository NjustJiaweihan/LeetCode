class Solution 
{
    List<Integer> result = new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        LDR(root);
        return result;
    }
    
    public void LDR(TreeNode root)
    {
        if(root != null)
        {
            LDR(root.left);
            result.add(root.val);
            LDR(root.right);
        }
    }
}
