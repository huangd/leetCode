package leetcode;

/**
 * User: huangd
 * Date: 12/29/12
 * Time: 11:42 AM
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        } else {
            if (isValidNode(node, min, max)) {
                boolean leftValid = isValidBST(node.left, min, node.val);
                boolean rightValid = isValidBST(node.right, node.val, max);
                return leftValid && rightValid;
            } else {
                return false;
            }
        }
    }

    private boolean isValidNode(TreeNode node, int min, int max) {
        if (node.val > min && node.val < max) {
            return true;
        } else {
            return false;
        }
    }
}
