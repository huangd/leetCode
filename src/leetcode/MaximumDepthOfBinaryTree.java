package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 8:28 PM
 */
public class MaximumDepthOfBinaryTree {

    private int maxLevel;
    private Queue<TreeNode> queue;

    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        queue = new LinkedList<TreeNode>();
        maxLevel = 0;
        if (root != null) {
            root.val = 1;
            queue.add(root);
            process();
        }
        return maxLevel;
    }

    private void process() {
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            updateMaxLevel(node);
            if (node.left != null) {
                node.left.val = node.val + 1;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + 1;
                queue.add(node.right);
            }
        }
    }

    private void updateMaxLevel(TreeNode node) {
        if (node.val > maxLevel) {
            maxLevel = node.val;
        }
    }
}
