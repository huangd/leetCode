package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by huangd on 9/20/15.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalII {

    private List<List<Integer>> levelOrder = null;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrder = new ArrayList<List<Integer>>();
        updateList(root, 0);
        Collections.reverse(levelOrder);
        return levelOrder;
    }

    private void updateList(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (levelOrder.size() <= level) {
            levelOrder.add(new ArrayList<Integer>());
        }
        levelOrder.get(level).add(node.val);
        updateList(node.left, level + 1);
        updateList(node.right, level + 1);
    }
}
