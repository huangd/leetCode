package leetcode;

/**
 * User: huangd
 * Date: 3/10/13
 * Time: 10:43 AM
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dumbHead = new ListNode(0);
        dumbHead.next = head;
        ListNode start = head;
        ListNode end = head;
        for (int i = 1; i < k; ++i) {
            if (end != null) {
                end = end.next;
            }
        }
        if (end != null && end != head) {
            end = end.next;
            ListNode current = start;
            ListNode pre = null;
            ListNode next = current.next;
            while (current != end) {
                current.next = pre;
                pre = current;
                current = next;
                if (current != null) {
                    next = current.next;
                }
            }

            dumbHead.next = pre;
            start.next = reverseKGroup(end, k);

        }
        return dumbHead.next;
    }
}
