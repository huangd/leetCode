package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * User: huangd
 * Date: 12/26/12
 * Time: 5:12 PM
 */
public class MergeIntervals {

    //Not sure if it is the right solution. Intervals need to implements Comparable interface
    private ArrayList<Interval> intervalArrayList;

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        intervalArrayList = new ArrayList<Interval>();
        Interval newInterval = null;
        Collections.sort(intervals);
        for (int i = 0; i < intervals.size(); ++i) {
            newInterval = process(intervals.get(i), newInterval);
        }
        process(null, newInterval);
        return intervalArrayList;
    }

    private Interval process(Interval interval, Interval newInterval) {
        if (interval == null) {
            intervalArrayList.add(newInterval);
            return null;
        } else {
            if (newInterval == null) {
                return interval;
            } else {
                if (newInterval.end < interval.start) {
                    intervalArrayList.add(newInterval);
                    return interval;
                } else if (newInterval.end >= interval.start && newInterval.end <= interval.end) {
                    return new Interval(newInterval.start, interval.end);
                } else {
                    return newInterval;
                }
            }
        }
    }
}
