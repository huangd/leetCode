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

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int j = m - 1;
        int k = n - 1;
        while (j >= 0 && k >= 0) {
            if (nums1[j] > nums2[k]) {
                nums1[i] = nums1[j];
                j--;
            } else {
                nums1[i] = nums2[k];
                k--;
            }
            i--;
        }
        while (k >= 0) {
            nums1[i] = nums2[k];
            i--;
            k--;
        }
    }
}


