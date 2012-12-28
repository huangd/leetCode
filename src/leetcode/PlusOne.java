package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 5:13 PM
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carryOver = 1;
        for (int i = digits.length - 1; i >= 0 && carryOver == 1; --i) {
            digits[i] = digits[i] + carryOver;
            if (digits[i] > 9) {
                digits[i] -= 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
        }
        if (carryOver == 1) {
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
