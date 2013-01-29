package leetcode;

/**
 * User: huangd
 * Date: 1/28/13
 * Time: 9:24 PM
 */
public class BalancedBinaryTree {

    private boolean isStillBallanced;
    public boolean isBalanced(TreeNode root) {
        isStillBallanced = true;
        if(root == null){
            return true;
        }
        getDepth(root);
        return isStillBallanced;
    }

    public int getDepth(TreeNode treeNode){
        if(treeNode == null || !isStillBallanced){
            return 0;
        }else{
            int leftDepth = getDepth(treeNode.left);
            int rightDepth = getDepth(treeNode.right);
            if(Math.abs(leftDepth-rightDepth) > 1){
                isStillBallanced = false;
            }
            return Math.max(leftDepth, rightDepth)+1;
        }
    }
}
