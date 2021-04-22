public class BinaryTreeInorderTraversal94 {
    // Recursive Approach: Time complexity : O(n)
    // Space complexity : The worst case space O(n), the average case is O(logn)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        helper(root, result);
        return result;
    }

    public static void helper(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    // Iterating method using Stack: Time complexity : O(n), Space complexity : O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}