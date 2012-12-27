package leetcode;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 12:01 AM
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0 || B.length == 0) {
            if (A.length == 0) {
                return getMedian(B);
            } else {
                return getMedian(A);
            }
        }

        if (A.length <= 2 || B.length <= 2) {
            return getMedianBase(A, B);
        } else {
            if (A[A.length / 2] > B[B.length / 2]) {//Make sure A<B
                int[] tmp = A;
                A = B;
                B = tmp;
            }
            int minDrop = Math.min(A.length - A.length / 2 - 1, B.length - B.length / 2 - 1);
            return findMedianSortedArrays(Arrays.copyOfRange(A, minDrop, A.length),
                    Arrays.copyOfRange(B, 0, B.length - minDrop));
        }
    }

    private double getMedianBase(int[] A, int[] B) {
        if (A.length > B.length) {//Make sure A.length <= 2
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        int[] combine;
        int evenOddLength = 5;
        if (B.length / 2 * 2 == B.length) {//even
            evenOddLength = 4;
        }
        int minLength = Math.min(evenOddLength, B.length);
        combine = new int[A.length + minLength];
        int i;
        for (i = 0; i < A.length; ++i) {
            combine[i] = A[i];
        }
        for (int j = B.length / 2 - minLength / 2; minLength > 0; --minLength, ++j, ++i) {
            combine[i] = B[j];
        }
        Arrays.sort(combine);
        return getMedian(combine);
    }

    private double getMedian(int[] anArray) {
        int mid = anArray.length / 2;
        if (mid * 2 == anArray.length) { // even
            return (anArray[mid - 1] + anArray[mid]) / 2.0;
        } else {
            return anArray[mid];
        }
    }
}
