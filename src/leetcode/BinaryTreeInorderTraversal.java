package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: huangd
 * Date: 1/30/13
 * Time: 7:53 PM
 */
public class BinaryTreeInorderTraversal {

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        res.add(node.val);
        inorderTraversal(node.right);
    }
}
