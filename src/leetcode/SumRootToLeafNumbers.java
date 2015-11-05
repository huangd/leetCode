package leetcode;

import java.util.LinkedList;

/**
 * User: huangd
 * Date: 2/21/13
 * Time: 11:27 PM
 */
public class SumRootToLeafNumbers {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null) dfs(root, new LinkedList<>());
        return sum;
    }

    void dfs(TreeNode node, LinkedList<TreeNode> nodePath) {
        nodePath.add(node);
        if (node.left != null) dfs(node.left, nodePath);
        if (node.right != null) dfs(node.right, nodePath);
        if (node.left == null && node.right == null) {
            sum += nodePath.stream()
                    .mapToInt(thisNode -> thisNode.val)
                    .reduce(0, (sum, val) -> sum * 10 + val);
        }
        nodePath.removeLast();
    }
}
