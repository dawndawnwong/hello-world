public class BinaryTreePaths257 {
    // Recursive Approach: Time complexity : O(n)
    // Space complexity : The worst case space O(n), the best case is O(logn)
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, "");
        return result;
    }

    private void helper(TreeNode root, List<String> result, String path) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
        }
        if (root.left != null) {
            helper(root.left, result, path + root.val + "->");
        }
        if (root.right != null) {
            helper(root.right, result, path + root.val + "->");
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val)); //result.add("" + root.val)
            return result;
        }
        List<String> leftResult = binaryTreePaths(root.left);
        List<String> rightResult = binaryTreePaths(root.right);
        for (String left : leftResult) {
            result.add(root.val + "->" + left);
        }

        for (String right : rightResult) {
            result.add(root.val + "->" + right);
        }
        return result;
    }
}