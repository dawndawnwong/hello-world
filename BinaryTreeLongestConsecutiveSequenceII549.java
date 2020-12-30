public class BinaryTreeLongestConsecutiveSequenceII549 {
    int result = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return result;
    }

    public int[] helper(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        int icr = 1, dcr = 1;
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                icr = left[1] + 1;
            }
            if (root.left.val == root.val - 1) {
                dcr = left[0] + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                icr = Math.max(icr, right[1] + 1);
            }
            if (root.right.val == root.val - 1) {
                dcr = Math.max(dcr, right[0] + 1);
            }
        }
        result = Math.max(result, icr + dcr - 1);
        return new int[] { dcr, icr };
    }
}
