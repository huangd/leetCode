package leetcode;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 1/28/13
 * Time: 9:41 PM
 */
public class BalancedBinaryTreeTest {
    @org.junit.Test
    public void testIsBalanced() throws Exception {
        TreeNode root = new TreeNode(2);
        TreeNode lNode = new TreeNode(1);
        TreeNode rNode = new TreeNode(3);
        root.left = lNode;
        root.right = rNode;

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        assertEquals(true, balancedBinaryTree.isBalanced(root));
    }
}
