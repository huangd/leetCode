package leetcode;

/**
 * User: huangd
 * Date: 2/14/13
 * Time: 9:21 PM
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isSameSubTree(p, q);
    }

    public boolean isSameSubTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }
}
