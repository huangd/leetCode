package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 2/21/13
 * Time: 11:27 PM
 */
public class SumRootToLeafNumbers {

    private int sum;

    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        sum = 0;
        if (root != null) {
            ArrayList<String> digitList = new ArrayList<String>();
            digitList.add(root.val + "");
            backtrack(digitList, root);
        }
        return sum;
    }

    private void backtrack(ArrayList<String> digitList, TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null) {
            sum += digitListToInteger(digitList);
        } else {
            if (treeNode.left != null) {
                int left = treeNode.left.val;
                digitList.add(left + "");
                backtrack(digitList, treeNode.left);
                digitList.remove(digitList.size() - 1);
            }
            if (treeNode.right != null) {
                int right = treeNode.right.val;
                digitList.add(right + "");
                backtrack(digitList, treeNode.right);
                digitList.remove(digitList.size() - 1);
            }
        }
    }

    private int digitListToInteger(ArrayList<String> digitList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String digit : digitList) {
            stringBuilder.append(digit);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
