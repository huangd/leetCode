package leetcode;

/**
 * User: huangd
 * Date: 3/10/13
 * Time: 2:41 PM
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode start = head;
        ListNode end = start;
        int length = 0;
        while (start != null) {
            ++length;
            end = start;
            start = start.next;
        }
        if (length == 0) {
            return head;
        } else {
            end.next = head;
            n = n % length;
            n = length - n - 1;
            if (n < 0) {
                n += length;
            }
            while (n > 0) {
                --n;
                head = head.next;
            }
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }
    }
}
