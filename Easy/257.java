正解：

class Solution
{
    List<String> allPaths = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root)
    {
        String path = "";
        dfs(root, path);

        return allPaths;
    }

    public void dfs(TreeNode root, String path)
    {
        if(root == null)
        {
            return;
        }
        path += "->" + root.val;

        if(root.left != null)
        {
            dfs(root.left, path);
        }
        if(root.right != null)
        {
            dfs(root.right, path);
        }
        if(root.left == null && root.right == null)
        {
            allPaths.add(path.substring(2));
        }
    }
}

错解：

class Solution
{
    List<String> allPaths = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root)
    {
        StringBuffer path = new StringBuffer();
        dfs(root, path);

        return allPaths;
    }

    public void dfs(TreeNode root, StringBuffer path)
    {
        if(root == null)
        {
            return;
        }
        path.append("->").append(root.val);

        if(root.left != null)
        {
            dfs(root.left, path);
        }
        if(root.right != null)
        {
            dfs(root.right, path);
        }
        if(root.left == null && root.right == null)
        {
            allPaths.add(path.substring(2));
        }
    }
}

修正解：

class Solution
{
    List<String> allPaths = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root)
    {
        StringBuffer path = new StringBuffer();
        dfs(root, path);

        return allPaths;
    }

    public void dfs(TreeNode root, StringBuffer path)
    {
        if(root == null)
        {
            return;
        }
        path.append("->").append(root.val);

        if(root.left != null)
        {
            dfs(root.left, new StringBuffer(path.toString()));
        }
        if(root.right != null)
        {
            dfs(root.right, new StringBuffer(path.toString()));
        }
        if(root.left == null && root.right == null)
        {
            allPaths.add(path.substring(2));
        }
    }
}
