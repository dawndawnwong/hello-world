public class MaximumAverageSubtree1120 {
    double result = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return result;
    }
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        result = Math.max(1.0 * sum / count, result);
        return new int[] {sum,count};
    }
}