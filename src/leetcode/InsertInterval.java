package leetcode;

import java.util.ArrayList;

/**
 * User: huangd
 * Date: 12/24/12
 * Time: 11:10 PM
 */
public class InsertInterval {

    private ArrayList<Interval> mergedList;

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mergedList = new ArrayList<Interval>();
        process(intervals, 0, newInterval);
        return mergedList;
    }

    private void process(ArrayList<Interval> intervals, int index, Interval newInterval) {
        if (index < intervals.size()) {
            int start = newInterval.start;
            int end = newInterval.end;
            Interval currentInterval = intervals.get(index);
            if (start < currentInterval.start) {
                if (end < currentInterval.start) {
                    mergedList.add(newInterval);
                    addRest(intervals, index, mergedList);
                } else if (end >= currentInterval.start && end <= currentInterval.end) {
                    Interval aInterval = new Interval(start, currentInterval.end);
                    mergedList.add(aInterval);
                    addRest(intervals, index + 1, mergedList);
                } else {//end>currentInterval.end
                    process(intervals, index + 1, newInterval);
                }
            } else if (start >= currentInterval.start && start <= currentInterval.end) {
                if (end <= currentInterval.end) {
                    addRest(intervals, index, mergedList);
                } else {//end>currentInterval.end
                    Interval aInterval = new Interval(currentInterval.start, end);
                    process(intervals, index + 1, aInterval);
                }
            } else {//start > currentInterval.end
                mergedList.add(currentInterval);
                process(intervals, index + 1, newInterval);
            }
        } else {
            mergedList.add(newInterval);
        }
    }

    private void addRest(ArrayList<Interval> from, int index, ArrayList<Interval> to) {
        for (; index < from.size(); ++index) {
            to.add(from.get(index));
        }
    }
}
