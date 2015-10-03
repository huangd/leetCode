package leetcode;

/**
 * Created by huangd on 10/3/15.
 */
public class RectangleArea {
    public class Solution {
        public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
            int areaOne = area(A, B, C, D);
            int areaTwo = area(E, F, G, H);
            if (A >= G || E >= C || F >= D || B >= H) {
                return areaOne + areaTwo;
            }
            return areaOne + areaTwo - area(Math.max(A, E), Math.max(B, F), Math.min(C, G), Math.min(D, H));
        }

        private int area(int a, int b, int c, int d) {
            return Math.abs(c - a) * Math.abs(d - b);
        }
    }
}
