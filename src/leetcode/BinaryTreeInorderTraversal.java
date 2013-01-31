package leetcode;

import java.util.ArrayList;

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
        if (treeNode != null) {
            inOrder(treeNode.left);
            resultList.add(treeNode.val);
            inOrder(treeNode.right);
        }
    }
}
