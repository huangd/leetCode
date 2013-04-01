package leetcode;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 3/31/13
 * Time: 4:43 PM
 */
public class ReverseLinkedListIITest {

    ListNode head = null;

    @Before
    public void setUp() throws Exception {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        head = one;
    }

    @Test
    public void testReverseBetween() throws Exception {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode newHead = reverseLinkedListII.reverseBetween(head, 3, 3);
        assertEquals(1, newHead.val);
    }
}
