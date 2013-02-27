package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 2/26/13
 * Time: 7:03 PM
 */
public class RecoverBinarySearchTree {

    private TreeNode preNode;
    private ArrayList<TreeNode> nodeList;//The size of this list is at most 4

    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        preNode = null;
        nodeList = new ArrayList<TreeNode>();
        inOrderTraverse(root);
        correctValue();
    }

    private void inOrderTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            inOrderTraverse(treeNode.left);
            if (preNode != null) {
                if (preNode.val > treeNode.val) {
                    nodeList.add(preNode);
                    nodeList.add(treeNode);
                }
            }
            preNode = treeNode;
            inOrderTraverse(treeNode.right);
        }
    }

    private void correctValue() {
        TreeNode one = nodeList.get(0);
        TreeNode two = nodeList.get(nodeList.size() - 1);
        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }
}
