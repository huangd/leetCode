package leetcode;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 1:09 PM
 */
public class ConstructBinaryTreeInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return getRoot(inorder, postorder);
    }

    private TreeNode getRoot(int[] inOrder, int[] postOrder) {
        int length = postOrder.length;
        if (length == 0) {
            return null;
        }
        int rootVal = postOrder[length - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInOrder = getRootIndex(inOrder, rootVal);
        TreeNode left = getRoot(Arrays.copyOfRange(inOrder, 0, rootIndexInOrder),
                Arrays.copyOfRange(postOrder, 0, rootIndexInOrder));
        TreeNode right = getRoot(Arrays.copyOfRange(inOrder, rootIndexInOrder + 1, inOrder.length),
                Arrays.copyOfRange(postOrder, rootIndexInOrder, inOrder.length - 1));
        root.left = left;
        root.right = right;
        return root;
    }

    private int getRootIndex(int[] inOrder, int rootVal) {
        int rootIndex = -1;
        for (int i = 0; i < inOrder.length; ++i) {
            if (inOrder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        return rootIndex;
    }
}
