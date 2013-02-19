package leetcode;

import java.util.Arrays;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 9:15 PM
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] numbersSorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbersSorted);
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbersSorted[i] + numbersSorted[j] == target) {
                return getIndex(numbers, numbersSorted[i], numbersSorted[j]);
            } else if (numbersSorted[i] + numbersSorted[j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        return new int[2];
    }

    private int[] getIndex(int[] numbers, int one, int two) {
        int indexOne = -1;
        int indexTwo = -1;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] == one && indexOne == -1) {
                indexOne = i;
            } else if (numbers[i] == two && indexTwo == -1) {
                indexTwo = i;
            }
        }
        if (indexOne < indexTwo) {
            return new int[]{indexOne + 1, indexTwo + 1};
        } else {
            return new int[]{indexTwo + 1, indexOne + 1};
        }
    }
}
