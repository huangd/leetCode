package leetcode;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 1:09 PM
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override public boolean equals(Object object) {
        if (object instanceof TreeNode) {
            TreeNode thatTreeNode = ((TreeNode) object);
            if (thatTreeNode.val == val && thatTreeNode.left == left && thatTreeNode.right == right) {
                return true;
            }
        }
        return false;
    }
}