package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 7:47 PM
 */
public class MinimumDepthOfBinaryTree {

    private Queue<TreeNode> queue;

    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        queue = new LinkedList<TreeNode>();
        if (root != null) {
            root.val = 1;
            queue.add(root);
        }
        return process();
    }

    private int process() {
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode right = node.right;
            TreeNode left = node.left;
            if (right == null && left == null) {
                return node.val;
            } else {
                if (right != null) {
                    right.val = node.val + 1;
                    queue.add(right);
                }
                if (left != null) {
                    left.val = node.val + 1;
                    queue.add(left);
                }
            }
        }
        return 0;
    }
}
