package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by huangd on 10/14/15.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] forwardProduct = new int[nums.length];
        forwardProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            forwardProduct[i] = forwardProduct[i - 1] * nums[i];
        }
        int[] backwardProduct = new int[nums.length];
        backwardProduct[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0 ; i--) {
            backwardProduct[i] = backwardProduct[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int forward = i - 1 < 0 ? 1 : forwardProduct[i - 1];
            int backward = i + 1 > nums.length - 1 ? 1 : backwardProduct[i + 1];
            res[i] = forward * backward;
        }
        return res;
    }
}
