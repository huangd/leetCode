package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: huangd
 * Date: 1/30/13
 * Time: 7:58 PM
 */
public class BinaryTreeLevelOrderTraversal {

    private List<List<Integer>> results;

    public List<List<Integer>> levelOrder(TreeNode root) {
        results = new ArrayList<List<Integer>>();
        levelOrder(root, 0);
        return results;
    }

    private void levelOrder(TreeNode root, int levelNumber) {
        if (root == null) {
            return;
        }
        if (results.size() == levelNumber) {
            results.add(new ArrayList<Integer>());
        }
        results.get(levelNumber).add(root.val);
        levelOrder(root.left, levelNumber + 1);
        levelOrder(root.right, levelNumber + 1);
    }
}
