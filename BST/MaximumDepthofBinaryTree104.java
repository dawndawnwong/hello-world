class MaximumDepthofBinaryTree104 {
    // Recursive Approach: Time complexity : O(n)
    // Space complexity : The worst case space O(n), the best case is O(logn)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    // Iterating method using Stack: Time complexity : O(n) 
    // Space complexity : The worst case space O(n), the average case is O(logn)
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        TreeNode node = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        int max = 0;
        int depth = 1;

        while(node != null || !nodeStack.empty()) {
            while (node != null) {
                nodeStack.push(node);
                depthStack.push(depth);
                node = node.left;
                depth++;
            }
            node = nodeStack.pop();
            depth = depthStack.pop();
            if (depth > max) {
                max = depth;
            }
            node = node.right;
            depth++;
        }
        return max;
    }
}