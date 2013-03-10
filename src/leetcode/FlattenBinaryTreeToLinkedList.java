package leetcode;

import java.util.Stack;

/**
 * User: huangd
 * Date: 2/1/13
 * Time: 10:10 PM
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null) {
            preOrder(root);
        }
    }

    private void preOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (pre != null) {
                pre.right = current;
            }
            current.left = null;
            current.right = null;
            pre = current;
        }
    }
}
