package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by huangd on 9/20/15.
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 */
public class HappyNumber {
    Set<Integer> candidateSet = new HashSet<Integer>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        if (candidateSet.contains(n)) {
            return false;
        }
        candidateSet.add(n);

        int squareSum = 0;
        while (n != 0) {
            squareSum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return isHappy(squareSum);
    }
}
