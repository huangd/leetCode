package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 8:28 PM
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) {
            return 0;
        }
        int valid = 1;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] != A[i - 1]) {
                A[valid] = A[i];
                ++valid;
            }
        }
        return valid;
    }
}