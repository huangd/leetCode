package leetcode;

/**
 * User: huangd
 * Date: 12/28/12
 * Time: 9:49 PM
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        return (a != null && b != null && a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left));
    }
}
