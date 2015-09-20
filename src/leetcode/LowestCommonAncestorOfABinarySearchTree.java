package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huangd on 9/19/15.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathContainP = findNodePath(root, p);
        for (TreeNode node : pathContainP) {
            if (containsTargetNode(node, q)) {
                return node;
            }
        }
        return null;
    }

    /**
     * It return the TreeNode path from target treeNode to root if it finds the target TreeNode otherwise it returns null
     */
    private List<TreeNode> findNodePath(TreeNode root, TreeNode target) {
        // Reach the leaf node
        if (root == null) {
            return null;
        }
        // Find the target node
        if (root.equals(target)) {
            return new ArrayList(Arrays.asList(root));
        }
        List<TreeNode> leftPath = findNodePath(root.left, target);
        List<TreeNode> rightPath = findNodePath(root.right, target);
        if (leftPath == null && rightPath == null) {
            return null;
        } else {
            // Find the target node in either left descendants or right descendants
            List<TreeNode> path = leftPath == null ? rightPath : leftPath;
            path.add(root);
            return path;
        }
    }

    private boolean containsTargetNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root.equals(target)) {
            return true;
        }
        return containsTargetNode(root.left, target) || containsTargetNode(root.right, target);
    }
}
