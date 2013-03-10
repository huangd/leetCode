package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 9:40 PM
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dumbHead = new ListNode(0);
        dumbHead.next = head;
        ListNode current = head;
        ListNode pre = dumbHead;
        while (current != null) {
            boolean dup = false;
            while (current.next != null && current.next.val == current.val) {
                dup = true;
                current = current.next;
            }
            if (dup) {
                pre.next = current.next;
            } else {
                pre = current;
            }
            current = current.next;
        }
        return dumbHead.next;
    }
}
