public class InorderSuccessorinBST285 {
    //recursion
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
       if (root == null) return null;
       if (p.val >= root.val) {
           return inorderSuccessor(root.right, p);
       } else {
           TreeNode temp = inorderSuccessor(root.left, p);
           if (temp != null) return temp;
           else return root;
       }
    }

    //non-recursion (Traverse)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                result = root;
                root = root.left;
            }
        }
        return result;
     }
}
