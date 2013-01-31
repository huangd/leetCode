package leetcode;

/**
 * User: huangd
 * Date: 1/30/13
 * Time: 8:35 PM
 */
public class BinaryTreeMaximumPathSum {

    private int maxPath;

    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        maxPath = root.val;
        maxNodeSum(root);
        return maxPath;
    }

    private int maxNodeSum(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int maxNodeLeft = maxNodeSum(treeNode.left);
            int maxNodeRight = maxNodeSum(treeNode.right);
            maxPath = Math.max(treeNode.val + maxNodeLeft + maxNodeRight, maxPath);
            int tmp = Math.max(treeNode.val + maxNodeLeft, treeNode.val + maxNodeRight);
            int maxSum = Math.max(treeNode.val, tmp);
            maxPath = Math.max(maxSum, maxPath);
            return maxSum;
        }
    }
}
