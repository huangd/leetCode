package leetcode;

/**
 * Created by huangd on 9/30/15.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumbNode = new ListNode(0);
        dumbNode.next = head;
        ListNode nodeOne = dumbNode;
        ListNode nodeTwo = dumbNode;
        while (n > 0) {
            nodeOne = nodeOne.next;
            n--;
        }
        while (nodeOne.next != null) {
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next;
        }
        nodeTwo.next = nodeTwo.next.next;
        return dumbNode.next;
    }
}
