package leetcode;

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode runner = head;
        ListNode chaser = head;
        ListNode prev = null;
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            prev = chaser;
            chaser = chaser.next;
        }
        TreeNode newRoot = new TreeNode(chaser.val);
        newRoot.right = sortedListToBST(chaser.next);
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        newRoot.left = sortedListToBST(head);
        return newRoot;
    }
}
