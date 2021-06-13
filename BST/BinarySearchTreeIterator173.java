public class BinarySearchTreeIterator173 {
    private Stack<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        if (cur != null || !stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
