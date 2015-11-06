package leetcode;

public class PerfectSquares {
    // Runtime is too slow. This could be solved by dynamic programming which builds the solution from bottom
    Map<Integer, Integer> cache = new HashMap<>();
    public int numSquares(int n) {
        if (n == 0) return 0;
        if (cache.get(n) != null) return cache.get(n);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (i * i <= n) {
                min = Math.min(min, 1 + numSquares(n - i * i));
            }
        }
        cache.put(n, min);
        return min;
    }
}
