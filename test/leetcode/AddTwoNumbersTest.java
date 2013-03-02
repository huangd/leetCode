package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 8:28 PM
 */
public class AddTwoNumbersTest {
    @Test
    public void testAddTwoNumbers() throws Exception {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode sum = addTwoNumbers.addTwoNumbers(l1, l2);
        assertEquals(sum.val, 0);
        assertEquals(sum.next.val, 1);
    }
}
