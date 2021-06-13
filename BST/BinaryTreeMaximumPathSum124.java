public class BinaryTreeMaximumPathSum124 {
    int result;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        result = Integer.MIN_VALUE;
        helper(root);
        return result;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        result = Math.max(result, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
