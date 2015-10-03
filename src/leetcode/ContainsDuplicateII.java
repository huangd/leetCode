package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by huangd on 10/3/15.
 */
public class ContainsDuplicateII {
    LinkedList<Integer> fixedSizeList = new LinkedList<Integer>();
    Set<Integer> fixedSizeSet = new HashSet<Integer>();
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i : nums) {
            if (fixedSizeList.size() == k + 1) {
                fixedSizeSet.remove(fixedSizeList.removeFirst());
            }
            if (fixedSizeSet.contains(i)) {
                return true;
            }
            fixedSizeList.add(i);
            fixedSizeSet.add(i);
        }
        return false;
    }
}
