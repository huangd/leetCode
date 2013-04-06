package leetcode;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 4/5/13
 * Time: 7:33 PM
 */
public class ConstructBinaryTreePreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (preorder.length == 0) {
            return null;
        } else {
            TreeNode rootNode = new TreeNode(preorder[0]);
            int rootIndex = rootIndex(inorder, rootNode.val);
            TreeNode leftNode = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                    Arrays.copyOfRange(inorder, 0, rootIndex));
            TreeNode rightNode = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
                    Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
            rootNode.left = leftNode;
            rootNode.right = rightNode;
            return rootNode;
        }
    }

    public int rootIndex(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == val) {
                return i;
            }
        }
        throw new IllegalArgumentException("Input is invalid");
    }
}
