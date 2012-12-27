package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 12:39 PM
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            return process(root, sum);
        }
    }

    public boolean process(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return true;
            } else {
                return false;
            }
        } else {
            boolean left = false;
            boolean right = false;
            if (root.left != null) {
                left = process(root.left, sum - root.val);
            }
            if (root.right != null) {
                right = process(root.right, sum - root.val);
            }

            return left || right;
        }
    }
}
