public class BinaryTreePreorderTraversal144 {
    // Recursive Approach: Time complexity : O(n)
    // Space complexity : The worst case space O(n), the average case is O(logn)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        helper(root,result);
        return result;
    }
    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }

    // Iterating method using Stack: Time complexity : O(n), Space complexity : O(n)
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            } 
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}