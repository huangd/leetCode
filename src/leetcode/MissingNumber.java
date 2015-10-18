package leetcode;

import java.util.Arrays;

/**
 * Created by huangd on 10/18/15.
 */
public class MissingNumber {
    //The trick is that the number always starts from 0 to n and there is only one number that is missing
    public int missingNumber(int[] nums) {
        int theOne = 0;
        for (int i = 0; i < nums.length; i++) {
            theOne += i;
            theOne -= nums[i];
        }
        theOne += nums.length;
        return theOne;
    }
}
