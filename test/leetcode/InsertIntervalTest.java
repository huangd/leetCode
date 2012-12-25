package leetcode;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * User: huangd
 * Date: 12/25/12
 * Time: 12:01 AM
 */
public class InsertIntervalTest {
    @Test
    public void testInsert() throws Exception {
        InsertInterval insertInterval = new InsertInterval();
        Interval newInterval = new Interval(3, 8);
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(5, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(11, 13));

        ArrayList<Interval> expected = new ArrayList<Interval>();
        expected.add(new Interval(2, 10));
        expected.add(new Interval(11, 13));
        assertEquals(expected, insertInterval.insert(intervals, newInterval));
    }
}
