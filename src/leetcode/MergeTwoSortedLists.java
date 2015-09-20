package leetcode;

/**
 * User: huangd
 * Date: 3/2/13
 * Time: 9:48 AM
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dumbHead is a key to simplify this kind of problem
        ListNode dumbHead = new ListNode(0);
        ListNode pre = dumbHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dumbHead.next;
    }
}
