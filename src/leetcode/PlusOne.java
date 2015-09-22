package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 5:13 PM
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        digits[length - 1] += 1;
        for (int i = length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] -= 10;
                digits[i - 1] += 1;
            }
        }
        if (digits[0] == 10) {
            digits[0] -= 10;
            return digitsPlusOne(digits);
        } else {
            return digits;
        }
    }

    private int[] digitsPlusOne(int[] digits) {
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        for (int i = 0; i < digits.length; ++i) {
            newDigits[i + 1] = digits[i];
        }
        return newDigits;
    }
}
