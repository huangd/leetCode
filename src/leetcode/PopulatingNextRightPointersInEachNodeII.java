package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 11:23 PM
 */
public class PopulatingNextRightPointersInEachNodeII {
    //There is still a bug in this solution.
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null) {
            if (root.left != null) {
                TreeLinkNode next = null;
                TreeLinkNode rootNext = root.next;
                if (root.right != null) {
                    next = root.right;
                } else {
                    while (rootNext != null) {
                        if (rootNext.left != null) {
                            next = rootNext.left;
                            break;
                        } else if (rootNext.right != null) {
                            next = rootNext.right;
                            break;
                        } else {
                            rootNext = rootNext.next;
                        }
                    }
                }
                root.left.next = next;
            }
            if (root.right != null) {
                TreeLinkNode next = null;
                TreeLinkNode rootNext = root.next;
                while (rootNext != null) {
                    if (rootNext.left != null) {
                        next = rootNext.left;
                        break;
                    } else if (rootNext.right != null) {
                        next = rootNext.right;
                        break;
                    } else {
                        rootNext = rootNext.next;
                    }
                }
                root.right.next = next;
            }
            connect(root.left);
            connect(root.right);
        }
    }
}
