package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 5:48 PM
 */
public class MergeKSortedLists {

    private PriorityQueue<ListNode> heap;

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (lists == null || lists.size() == 0) {
            return null;
        }
        heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode1, ListNode listNode2) {
                return new Integer(listNode1.val).compareTo(new Integer(listNode2.val));
            }
        });
        ListNode dumbHead = new ListNode(0);
        ListNode preNode = dumbHead;
        populateHeap(lists);
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            preNode.next = node;
            if (node.next != null) {
                heap.add(node.next);
            }
            preNode = node;
        }
        return dumbHead.next;
    }

    private void populateHeap(ArrayList<ListNode> lists) {
        for (int i = 0; i < lists.size(); ++i) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
    }
}
