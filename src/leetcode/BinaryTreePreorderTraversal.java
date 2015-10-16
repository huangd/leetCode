package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangd on 10/14/15.
 */
public class BinaryTreePreorderTraversal {
    List<Integer> nodeList = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return nodeList;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        nodeList.add(node.val);
        traversal(node.left);
        traversal(node.right);
    }
}
