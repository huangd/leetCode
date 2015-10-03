package leetcode;

/**
 * Created by huangd on 10/3/15.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dumbHead = new ListNode(0);
        dumbHead.next = head;
        ListNode currentNode = dumbHead;
        ListNode nextNode = currentNode.next;
        while (nextNode != null) {
            if (nextNode.val == val) {
                currentNode.next = nextNode.next;

            } else {
                currentNode = nextNode;
            }
            nextNode = currentNode.next;
        }
        return dumbHead.next;
    }
}
