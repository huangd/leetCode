package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 9:28 PM
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode next = current.next;
        while (next != null && current.val == next.val) {
            current.next = next.next;
            next = current.next;
        }
        deleteDuplicates(next);
        return head;
    }
}
