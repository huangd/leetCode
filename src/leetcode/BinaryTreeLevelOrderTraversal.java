package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User: huangd
 * Date: 1/30/13
 * Time: 7:58 PM
 */
public class BinaryTreeLevelOrderTraversal {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<ArrayList<Integer>>();
        if (root != null) {
            Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            currentLevel.add(root);
            arrayListArrayList.add(new ArrayList<Integer>());
            while (!currentLevel.isEmpty()) {
                TreeNode treeNode = currentLevel.poll();
                arrayListArrayList.get(arrayListArrayList.size() - 1).add(treeNode.val);
                if (treeNode.left != null) {
                    nextLevel.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextLevel.add(treeNode.right);
                }

                if (currentLevel.isEmpty() && !nextLevel.isEmpty()) {
                    currentLevel = nextLevel;
                    nextLevel = new LinkedList<TreeNode>();
                    arrayListArrayList.add(new ArrayList<Integer>());
                }
            }

        }
        return arrayListArrayList;
    }
}
