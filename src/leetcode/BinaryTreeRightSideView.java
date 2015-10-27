package leetcode;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> sideViewList = new ArrayList<>();
        rightSideView(root, 0, sideViewList);
        return sideViewList;
    }

    void rightSideView(TreeNode node, int level, ArrayList<Integer> sideViewList) {
        if (node == null) return;
        if (sideViewList.size() == level) {
            sideViewList.add(level, node.val);
        } else {
            sideViewList.set(level, node.val);
        }
        rightSideView(node.left, level + 1, sideViewList);
        rightSideView(node.right, level + 1, sideViewList);
    }
}
