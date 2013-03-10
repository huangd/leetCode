package leetcode;

/**
 * User: huangd
 * Date: 3/9/13
 * Time: 7:07 PM
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int last = A.length - 1;
        for (int i = 0; i <= last; ++i) {
            if (A[i] == elem) {
                while (last >= 0 && A[last] == elem) {
                    last--;
                }
                if (last > i) {
                    A[i] = A[last];
                    last--;
                }
            }
        }
        return last + 1;
    }
}
