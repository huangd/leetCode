package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 5:40 PM
 */
public class PopulatingNextRightPointersInEachNode {

    private Queue<TreeLinkNode> queue;
    private Map<TreeLinkNode, Integer> nodeLevel;

    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null) {
            nodeLevel = new HashMap<TreeLinkNode, Integer>();
            nodeLevel.put(root, 1);
            queue = new LinkedList<TreeLinkNode>();
            queue.add(root);
            process();
        }
    }

    private void process() {
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            TreeLinkNode nextNode = queue.peek();
            if (nextNode != null) {
                if (nodeLevel.get(nextNode) == nodeLevel.get(node)) {
                    node.next = nextNode;
                }
            }
            if (node.left != null) {
                nodeLevel.put(node.left, nodeLevel.get(node) + 1);
                queue.add(node.left);
            }
            if (node.right != null) {
                nodeLevel.put(node.right, nodeLevel.get(node) + 1);
                queue.add(node.right);
            }
        }
    }
}
