package leetcode;

import java.util.ArrayList;

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
            process(root);
        }
    }

    private void process(TreeLinkNode root) {
        ArrayList<TreeLinkNode> current = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
        current.add(root);
        while (true) {
            link(current);
            for (int i = 0; i < current.size(); ++i) {
                TreeLinkNode currentNode = current.get(i);
                if (currentNode.left != null) {
                    next.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    next.add(currentNode.right);
                }
            }
            if (next.size() > 0) {
                current = next;
                next = new ArrayList<TreeLinkNode>();
            } else {
                break;
            }
        }
    }

    private void link(ArrayList<TreeLinkNode> current) {
        for (int i = 1; i < current.size(); ++i) {
            current.get(i - 1).next = current.get(i);
        }
    }
}
