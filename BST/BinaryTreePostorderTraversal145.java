public class BinaryTreePostorderTraversal145 {
    // Recursive Approach: Time complexity : O(n)
    // Space complexity : The worst case space O(n), the average case is O(logn)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
    
    // Iterating method using Stack: Time complexity : O(n), Space complexity : O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curt = stack.pop();
            result.addFirst(curt.val);
            if (curt.left != null) {
                stack.push(curt.left);
            }
            if (curt.right != null) {
                stack.push(curt.right);
            }
        }
        return result;
    }
}






}
