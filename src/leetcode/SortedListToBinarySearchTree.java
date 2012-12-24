package leetcode;

import sun.tools.tree.ThisExpression;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 12/23/12
 * Time: 5:38 PM
 */
public class SortedListToBinarySearchTree {
    //This is a buggy solution.
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return getRoot(head);
    }

    private TreeNode getRoot(ListNode head) {
        int length = getListLength(head);
        TreeNode root = null;
        if (length == 0) {
            return root;
        }
        int rootIndex = length/2;//Do not even to consider odd and even. Integer division will take care of it. :)
        root = new TreeNode(getNodeValue(head, rootIndex));
        TreeNode left = getRoot(getSubList(head, 0, rootIndex));
        TreeNode right = getRoot(getSubList(head, rootIndex+1, length));
        root.left = left;
        root.right = right;
        return root;
    }

    private ListNode getSubList(ListNode head, int from, int to){
        int current = 0;
        while(current != from){
            head = head.next;
            ++current;
        }
        ListNode subListHead = new ListNode(head.val);
        ListNode tmpHead = subListHead;
        while(current != to-1){
            head = head.next;
            ListNode aNode = new ListNode(head.val);
            tmpHead.next = aNode;
            tmpHead = aNode;
            ++current;
        }
        return subListHead;
    }

    private int getListLength(ListNode head){
        if(head == null){
            return 0;
        }
        int length = 1;
        while(head.next != null){
            head = head.next;
            ++length;
        }
        return length;
    }

    private int getNodeValue(ListNode head, int index){
        int current = 0;
        while(current != index){
            head = head.next;
            ++current;
        }
        return head.val;
    }
}
