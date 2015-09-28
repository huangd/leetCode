package leetcode;

/**
 * Created by huangd on 9/26/15.
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int twoCount = 0;
        int fiveCount = 0;
        for (int i = 1; i <= n; i++) {
            int two = i;
            while (two / 2 * 2 == two) {
                twoCount++;
                two /= 2;
            }
            int five = i;
            while (five / 5 * 5 == five) {
                fiveCount++;
                five /= 5;
            }
        }
        return Math.min(twoCount, fiveCount);
    }
}
