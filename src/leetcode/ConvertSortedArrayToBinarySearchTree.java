package leetcode;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 1/30/13
 * Time: 10:46 PM
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num.length == 0) {
            return null;
        } else {
            return getRoot(num);
        }
    }

    private TreeNode getRoot(int[] num) {
        int mid = num.length / 2;
        TreeNode root = new TreeNode(num[mid]);
        if (mid > 0) {
            root.left = getRoot(Arrays.copyOfRange(num, 0, mid));
        }
        if (num.length > mid + 1) {
            root.right = getRoot(Arrays.copyOfRange(num, mid + 1, num.length));
        }
        return root;
    }
}
