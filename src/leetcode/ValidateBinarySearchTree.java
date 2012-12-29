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
        if (root == null) {
            return true;
        } else {
            return process(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public boolean process(TreeNode node, int min, int max) {
        if (!isValidNode(node, min, max)) {
            return false;
        } else {
            TreeNode left = node.left;
            TreeNode right = node.right;
            boolean leftValid = true;
            boolean rightValid = true;
            if (left != null) {
                leftValid = process(left, min, node.val);
            }
            if (right != null) {
                rightValid = process(right, node.val, max);
            }
            return leftValid && rightValid;
        }
    }

    private boolean isValidNode(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        } else {
            if (node.val > min && node.val < max) {
                return true;
            } else {
                return false;
            }
        }
    }
}
