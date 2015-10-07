package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangd on 10/6/15.
 */
public class BinaryTreePaths {
    List<String> currentPath = new ArrayList<>();
    List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            traverse(root);
        }
        return paths;
    }

    private void traverse(TreeNode node) {
        currentPath.add(node.val + "");
        if (node.left == null && node.right == null) {
            paths.add(String.join("->", currentPath));

        }
        if (node.left != null) {
            traverse(node.left);
        }
        if (node.right != null) {
            traverse(node.right);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}
