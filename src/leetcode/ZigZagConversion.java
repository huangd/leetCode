package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by huangd on 10/6/15.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        List<List<Character>> matrix = new ArrayList<List<Character>>();
        for (int i = 0; i < numRows; i++) {
            matrix.add(new ArrayList<>());
        }
        boolean isDown = true;
        int row = 0;
        int column = 0;
        for (char c : s.toCharArray()) {
            matrix.get(row).add(column, c);
            if (row == 0) {
                isDown = true;
            }
            if (row == matrix.size() - 1) {
                isDown = false;
            }
            if (isDown && row < matrix.size() - 1) {
                row += 1;
            }
            if (!isDown && row > 0) {
                row -= 1;
            }
            column += 1;
        }
        List<Character> charList = matrix.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        StringBuilder builder = new StringBuilder();
        for (char c : charList) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        new ZigZagConversion().convert("AB", 2);
    }
}