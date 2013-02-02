package leetcode;

/**
 * User: huangd
 * Date: 2/1/13
 * Time: 10:10 PM
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        preOrder(root);
    }

    private TreeNode preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        } else {
            TreeNode leftChild = treeNode.left;
            TreeNode rightChild = treeNode.right;

            TreeNode leftEnd = preOrder(treeNode.left);
            if (leftEnd == null) {
                leftEnd = treeNode;
            }
            TreeNode rightEnd = preOrder(treeNode.right);
            if (rightEnd == null) {
                rightEnd = leftEnd;
            }

            treeNode.left = null;
            treeNode.right = leftChild;
            leftEnd.right = rightChild;
            return rightEnd;
        }
    }
}
