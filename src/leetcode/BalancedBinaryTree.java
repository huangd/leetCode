package leetcode;

/**
 * User: huangd
 * Date: 1/28/13
 * Time: 9:24 PM
 */
public class BalancedBinaryTree {

    private boolean isStillBalanced = true;

    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return isStillBalanced;
    }

    public int getDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = getDepth(treeNode.left);
        int rightDepth = getDepth(treeNode.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isStillBalanced = false;
            /**
             * terminate the recursive earlier
             * 0 is not the actually height of the tree but it does not matter because we know that this tree is not balanced.
             */
            return 0;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
