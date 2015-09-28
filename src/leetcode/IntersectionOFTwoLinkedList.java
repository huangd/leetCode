package leetcode;

/**
 * Created by huangd on 9/27/15.
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != null && nodeB != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        while (nodeB != null) {
            nodeB = nodeB.next;
            headB = headB.next;
        }
        while (nodeA != null) {
            nodeA = nodeA.next;
            headA = headA.next;
        }
        while  (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
