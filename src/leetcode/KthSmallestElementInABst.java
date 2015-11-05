package leetcode;

public class KthSmallestElementInABst {
  public int kthSmallest(TreeNode root, int k) {
    int countNodeLeft = countNode(root.left);
    if (countNodeLeft >= k) {
      return kthSmallest(root.left, k);
    } else if (countNodeLeft + 1 == k) {
      return root.val;
    } else {
      return kthSmallest(root.right, k - countNodeLeft - 1);
    }
  }

  int countNode(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return countNode(node.left) + 1 + countNode(node.right);
  }
}
