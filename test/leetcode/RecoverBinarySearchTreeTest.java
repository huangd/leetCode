package leetcode;

import org.junit.Test;

/**
 * User: huangd
 * Date: 2/26/13
 * Time: 7:47 PM
 */
public class RecoverBinarySearchTreeTest {
    @Test
    public void testRecoverTree() throws Exception {
        TreeNode nodeZero = new TreeNode(0);
        TreeNode nodeOne = new TreeNode(1);
        nodeZero.left = nodeOne;
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(nodeZero);
    }
}
