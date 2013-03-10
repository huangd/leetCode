package leetcode;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 10:48 PM
 */
public class FlattenBinaryTreeToLinkedListTest {
    @Test
    public void testFlatten() throws Exception {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        one.left = two;
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(one);
        assertTrue(one.left == null);
        assertTrue(one.right == two);
        assertTrue(two.left == null);
        assertTrue(two.right == null);
    }
}
