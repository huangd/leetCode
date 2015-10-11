package leetcode;

/**
 * Created by huangd on 10/11/15.
 */
public class FirstBadVersion {

    // TODO: cal mid needs to prevent int overflow
    int lower = 1;
    public int firstBadVersion(int n) {
        if (lower + 1 == n) {
            return lower;
        }
        int mid = (int)Math.floor(n / 2.0 + lower / 2.0);
        if (isBadVersion(mid)) {
            return firstBadVersion(mid);
        } else {
            lower = mid;
            return firstBadVersion(n);
        }
    }

    public boolean isBadVersion(int version) {
        return true;
    }
}
