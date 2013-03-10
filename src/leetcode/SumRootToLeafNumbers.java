package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
            Set<TreeNode> candidates = getCandidates(treeNode);
            for (TreeNode candidate : candidates) {
                digitList.add(candidate.val + "");
                backtrack(digitList, candidate);
                digitList.remove(digitList.size() - 1);
            }
        }
    }

    private Set<TreeNode> getCandidates(TreeNode treeNode) {
        Set<TreeNode> candidates = new HashSet<TreeNode>();
        if (treeNode.left != null) {
            candidates.add(treeNode.left);
        }
        if (treeNode.right != null) {
            candidates.add(treeNode.right);
        }
        return candidates;
    }

    private int digitListToInteger(ArrayList<String> digitList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String digit : digitList) {
            stringBuilder.append(digit);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
