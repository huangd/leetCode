package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * User: huangd
 * Date: 1/30/13
 * Time: 7:53 PM
 */
public class BinaryTreeInorderTraversal {

    private ArrayList<Integer> resultList;

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        resultList = new ArrayList<Integer>();
        inOrder(root);
        return resultList;
    }

    private void inOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = treeNode;
        boolean isFinished = false;
        while (!isFinished) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    isFinished = true;
                } else {
                    current = stack.pop();
                    resultList.add(current.val);
                    current = current.right;
                }
            }
        }
    }
}
