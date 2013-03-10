package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 9:28 PM
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) {
            return head;
        } else {
            ListNode dumbHead = new ListNode(head.val + 1);
            ListNode pre = dumbHead;
            while (head != null) {
                if (head.val != pre.val) {
                    pre.next = head;
                    pre = head;
                }
                head = head.next;
                pre.next = null;
            }
            return dumbHead.next;
        }
    }
}
