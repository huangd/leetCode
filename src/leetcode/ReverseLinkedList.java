package leetcode;

/**
 * Created by huangd on 9/20/15.
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;
        while (next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        return current;
    }
}
