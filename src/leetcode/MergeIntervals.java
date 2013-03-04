package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 5:12 PM
 */
public class MergeIntervals {

    private ArrayList<Interval> intervalArrayList;
    private Comparator<Interval> ORDER_BY_START = new Comparator<Interval>() {
        @Override
        public int compare(Interval interval, Interval interval2) {
            return new Integer(interval.start).compareTo(new Integer(interval2.start));
        }
    };

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        intervalArrayList = new ArrayList<Interval>();
        Interval newInterval = null;
        Collections.sort(intervals, ORDER_BY_START);
        for (int i = 0; i < intervals.size(); ++i) {
            newInterval = process(intervals.get(i), newInterval);
        }
        if (newInterval != null) {
            intervalArrayList.add(newInterval);
        }
        return intervalArrayList;
    }

    private Interval process(Interval interval, Interval newInterval) {
        if (newInterval == null) {
            return interval;
        } else {
            if (newInterval.end < interval.start) {
                intervalArrayList.add(newInterval);
                return interval;
            } else if (interval.end < newInterval.start) {
                intervalArrayList.add(interval);
                return newInterval;
            } else {
                return new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
    }
}
