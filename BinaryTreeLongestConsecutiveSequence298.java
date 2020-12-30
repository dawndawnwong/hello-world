public class BinaryTreeLongestConsecutiveSequence298 {
    private int result = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, 0, root.val);
        return result;
    }

    public void helper(TreeNode root, int curCount, int target) {
        if (root == null)
            return;
        if (root.val == target) {
            curCount++;
        } else {
            curCount = 1;
        }
        result = Math.max(result, curCount);
        helper(root.left, curCount, root.val + 1);
        helper(root.right, curCount, root.val + 1);
    }
}
