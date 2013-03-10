package leetcode;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 8:05 PM
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode dumbNode = new ListNode(0);
        ListNode pre = dumbNode;
        int carryOver = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryOver;
            if (sum >= 10) {
                sum -= 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
            l1.val = sum;
            pre.next = l1;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carryOver == 0) {
            if (l1 != null) {
                pre.next = l1;
            }
            if (l2 != null) {
                pre.next = l2;
            }
        } else {
            if (l1 != null) {
                pre.next = addOne(l1);
            } else if (l2 != null) {
                pre.next = addOne(l2);
            } else {
                pre.next = new ListNode(1);
            }
        }
        return dumbNode.next;
    }

    private ListNode addOne(ListNode listNode) {
        int carryOver = 1;
        ListNode dumbNode = new ListNode(0);
        ListNode pre = dumbNode;
        while (listNode != null) {
            int sum = listNode.val + carryOver;
            if (sum >= 10) {
                sum -= 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
            listNode.val = sum;
            pre.next = listNode;
            pre = pre.next;
            listNode = listNode.next;
        }
        if (carryOver == 1) {
            pre.next = new ListNode(1);
        }
        return dumbNode.next;
    }
}
