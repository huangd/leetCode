package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 11:10 PM
 */
public class InsertInterval {

    private ArrayList<Interval> mergedList;
    private Interval newInterval;

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mergedList = new ArrayList<Interval>();
        this.newInterval = newInterval;
        process(intervals);
        return mergedList;
    }

    private void process(ArrayList<Interval> intervals) {
        for (int index = 0; index < intervals.size(); index++) {
            int start = newInterval.start;
            int end = newInterval.end;
            Interval currentInterval = intervals.get(index);
            if (end < currentInterval.start) {
                mergedList.add(newInterval);
                addRest(intervals, index, mergedList);
                return;
            } else if (currentInterval.end < start) {
                mergedList.add(currentInterval);
            } else {
                newInterval
                        = new Interval(Math.min(start, currentInterval.start), Math.max(end, currentInterval.end));
            }
        }
        mergedList.add(newInterval);
    }

    private void addRest(ArrayList<Interval> from, int index, ArrayList<Interval> to) {
        for (; index < from.size(); ++index) {
            to.add(from.get(index));
        }
    }
}
