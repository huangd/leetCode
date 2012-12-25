package leetcode;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 6:30 PM
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int missingOne = 0;
        if (A.length == 0) {
            missingOne = 1;
        } else {
            process(A);
            for (int i = 0; i < A.length; ++i) {
                if (A[i] == 0) {
                    missingOne = i + 1;
                    break;
                }
                missingOne = i + 2;
            }
        }

        return missingOne;
    }

    private void process(int[] inputArray) {
        for (int i = 0; i < inputArray.length; ++i) {
            arrange(inputArray, i);
        }
    }

    private void arrange(int[] inputArray, int index) {
        if (inputArray[index] <= 0 || inputArray[index] > inputArray.length) {
            inputArray[index] = 0;
            return;
        } else if (inputArray[index] == index + 1) {
            return;
        } else {
            int value = inputArray[index];
            int tmp = inputArray[value - 1];
            inputArray[value - 1] = value;
            if (value == tmp) {
                tmp = -1;
            }
            inputArray[index] = tmp;
            arrange(inputArray, index);
        }
    }
}
