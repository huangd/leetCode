package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 9:11 PM
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        int level = 1;
        current.add(root);
        result.add(new ArrayList<Integer>());
        while (!current.isEmpty()) {
            TreeNode treeNode = current.poll();
            result.get(result.size() - 1).add(treeNode.val);

            if (treeNode.left != null) {
                next.add(treeNode.left);
            }
            if (treeNode.right != null) {
                next.add(treeNode.right);
            }

            if (current.isEmpty()) {
                if (level % 2 == 0) {
                    ArrayList<Integer> lastOne = result.get(result.size() - 1);
                    Collections.reverse(lastOne);
                }
                if (!next.isEmpty()) {
                    result.add(new ArrayList<Integer>());
                }
                ++level;
                current = next;
                next = new LinkedList<TreeNode>();
            }
        }
        return result;
    }
}
