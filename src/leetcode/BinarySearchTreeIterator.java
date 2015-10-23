package leetcode;

public class BSTIterator {

    Stack<TreeNode> levelNodes = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            levelNodes.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !levelNodes.empty();
    }

    public int next() {
        int returnValue = levelNodes.peek().val;
        TreeNode node = levelNodes.pop().right;
        while (node != null) {
            levelNodes.push(node);
            node = node.left;
        }
        return returnValue;
    }
}
