public class ConvertBinarySearchTreetoSortedDoublyLinkedList426 {
    Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node dummy = new Node();
        pre = dummy;
        helper(root);
        dummy.right.left = pre;
        pre.right = dummy.right;
        return dummy.right;
    }

    public void helper(Node root) {
        if (root == null)
            return;
        helper(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        helper(root.right);
    }
}

// Stack
public class ConvertBinarySearchTreetoSortedDoublyLinkedList426 {
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Deque<Node> stack = new ArrayDeque<>();
        Node dummy = new Node();
        Node pre = dummy;
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
            cur = cur.right;
        }
        dummy.right.left = pre;
        pre.right = dummy.right;
        return dummy.right;
    }
}
