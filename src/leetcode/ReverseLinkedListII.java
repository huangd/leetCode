package leetcode;

/**
 * User: huangd
 * Date: 3/31/13
 * Time: 4:37 PM
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dumbNode = new ListNode(0);
        dumbNode.next = head;
        ListNode pre = dumbNode;
        ListNode current = head;
        for (int i = 1; i < m; ++i) {
            pre = current;
            current = current.next;
        }
        pre.next = reverseNNode(current, n - m + 1);
        return dumbNode.next;
    }

    public ListNode reverseNNode(ListNode node, int n) {
        if (n <= 1) {
            return node;
        }
        ListNode pre = null;
        ListNode current = node;
        for (int i = 1; i < n; ++i) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        ListNode after = current.next;
        current.next = pre;
        node.next = after;
        return current;
    }
}
