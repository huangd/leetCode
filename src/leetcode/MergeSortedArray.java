package leetcode;

/**
 * User: huangd
 * Date: 3/2/13
 * Time: 9:40 AM
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = m - 1, j = n - 1, r = m + n - 1;
        for (; i >= 0 && j >= 0; ) {
            if (A[i] >= B[j]) {
                A[r] = A[i];
                --i;
            } else {
                A[r] = B[j];
                --j;
            }
            --r;
        }
        while (j >= 0) {
            A[r] = B[j];
            --j;
            --r;
        }
    }
}
