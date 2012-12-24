package leetcode;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 5:27 PM
 */
public class SortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return getRoot(num);
    }

    private TreeNode getRoot(int[] num) {
        int length = num.length;
        TreeNode root = null;
        if (length == 0) {
            return root;
        }
        int rootIndex = length/2;//Do not even to consider odd and even. Integer division will take care of it. :)
        root = new TreeNode(num[rootIndex]);
        TreeNode left = getRoot(Arrays.copyOfRange(num, 0, rootIndex));
        TreeNode right = getRoot(Arrays.copyOfRange(num, rootIndex+1, length));
        root.left = left;
        root.right = right;
        return root;
    }
}
