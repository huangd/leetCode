package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by huangd on 10/8/15.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        LinkedList<LinkedList<String>> range = new LinkedList<>();
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int preNum = nums[0];
        LinkedList<String> section = new LinkedList<>();
        section.add(preNum + "");
        range.add(section);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == preNum + 1) {
                range.getLast().addLast(num + "");
            } else {
                section = new LinkedList<>();
                section.add(num + "");
                range.add(section);
            }
            preNum = num;
        }

        return range.stream().map(aList -> {
            LinkedList<String> hasArrow = new LinkedList<>();
            hasArrow.addFirst(aList.getFirst());
            if (!aList.getLast().equals(aList.getFirst())) {
                hasArrow.add("->");
                hasArrow.addLast(aList.getLast());
            }
            return String.join("", hasArrow);
        }).collect(Collectors.toList());
    }
}
