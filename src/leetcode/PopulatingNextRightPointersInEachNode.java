package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 5:40 PM
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        if (root != null && root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.left);
            connect(root.right);
        }
    }
}
