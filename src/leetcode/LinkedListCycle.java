package leetcode;

/**
 * Created by huangd on 10/17/15.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode runner = head.next;
        ListNode chaser = head;
        while (runner != null && runner.next != null && chaser != null) {
            if (chaser == runner) {
                return true;
            }
            chaser = chaser.next;
            runner = runner.next.next;
        }
        return false;
    }
}
