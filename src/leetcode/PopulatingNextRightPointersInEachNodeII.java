package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 11:23 PM
 */
public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null) {
            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    root.left.next = getNextNeighbor(root.next);
                }
            }
            if (root.right != null) {
                root.right.next = getNextNeighbor(root.next);
            }
            connect(root.left);
            connect(root.right);
        }
    }

    private TreeLinkNode getNextNeighbor(TreeLinkNode treeLinkNode) {
        if (treeLinkNode == null) {
            return null;
        } else if (treeLinkNode.left != null) {
            return treeLinkNode.left;
        } else if (treeLinkNode.right != null) {
            return treeLinkNode.right;
        } else {
            return getNextNeighbor(treeLinkNode.next);
        }
    }
}
