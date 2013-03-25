package leetcode;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 8:28 PM
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
