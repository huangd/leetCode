package leetcode;

/**
 * User: huangd
 * Date: 12/28/12
 * Time: 9:49 PM
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null) {
            if (root.left == null && root.right == null) {
                return true;
            } else if (root.left != null && root.right != null) {
                return isSymmetricalNode(root.left, root.right);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean isSymmetricalNode(TreeNode aNode, TreeNode bNode) {
        if (aNode == null && bNode == null) {
            return true;
        } else if (aNode != null && bNode != null) {
            if (aNode.val == bNode.val) {
                return isSymmetricalNode(aNode.right, bNode.left)
                        && isSymmetricalNode(aNode.left, bNode.right);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
