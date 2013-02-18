package leetcode;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 10:05 AM
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode newHead = new ListNode(0);//This is the key point to create a util node
        newHead.next = head;
        ListNode current = newHead;
        while (current.next != null && current.next.next != null) {
            current.next = swapOnePair(current.next);
            current = current.next.next;
        }
        return newHead.next;
    }

    private ListNode swapOnePair(ListNode listNode) {
        ListNode secondNode = listNode.next;
        listNode.next = secondNode.next;
        secondNode.next = listNode;
        return secondNode;
    }
}
