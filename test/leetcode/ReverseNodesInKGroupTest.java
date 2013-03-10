package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * User: huangd
 * Date: 3/10/13
 * Time: 2:15 PM
 */
public class ReverseNodesInKGroupTest {
    @Test
    public void testReverseKGroup() throws Exception {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode reversed = reverseNodesInKGroup.reverseKGroup(one, 2);
        assertTrue(reversed.val == 2);
        assertTrue(reversed.next.val == 1);
    }
}
