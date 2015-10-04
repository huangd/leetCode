package leetcode;

/**
 * Created by huangd on 10/3/15.
 */
public class PalindromeLinkedList {
    /**
     * Destroy the List to reverse it.
     * TODO: finish the solution
     * - find the middle postion
     * - reverse the list in the second part
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode dumbNode = new ListNode(0);
        dumbNode.next = head;
        ListNode runner = dumbNode;
        ListNode chaser = dumbNode;
        while (runner.next != null) {
            chaser = chaser.next;
            runner = runner.next;
            if (runner.next == null) {
                continue;
            }
            runner = runner.next;
        }
        ListNode next = chaser.next;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = chaser;
            chaser = next;
            next = nextNext;
        }
        while (chaser == head || chaser.next == head && head.next == chaser) {
            if (chaser.val != head.val) {
                return false;
            }
            chaser = chaser.next;
            head = head.next;
        }
        return true;
    }
}
