package leetcode;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 11:12 PM
 */
public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object anObject) {
        if (anObject instanceof Interval) {
            Interval anInterval = (Interval) anObject;
            if (anInterval.start == this.start && anInterval.end == this.end) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
