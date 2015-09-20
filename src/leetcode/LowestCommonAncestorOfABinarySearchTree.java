package leetcode;

/**
 * Created by huangd on 9/19/15.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * TODO:
         * It would be easy if we had a ref from child to parent
         */
    }

    private Boolean containNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        return containNode(root.right, p) || containNode(root.left, p);
    }
}
