package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 5:40 PM
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null) {
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.right != null) {
                root.right.next = root.next == null ? null : root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
    }
}
