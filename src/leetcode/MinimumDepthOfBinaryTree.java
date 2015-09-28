package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 7:47 PM
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) { return 0; }
        return minDepth(root, 1);
    }

    private int minDepth(TreeNode node, int currentDepth) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return currentDepth;
        }
        return Math.min(minDepth(node.left, currentDepth + 1), minDepth(node.right, currentDepth + 1));
    }
}
