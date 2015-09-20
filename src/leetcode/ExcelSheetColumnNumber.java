package leetcode;

/**
 * Created by huangd on 9/19/15.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        char[] title = s.toCharArray();
        for (int i = title.length - 1; i >= 0 ; i--) {
            result += (title[i] - 'A' + 1) * Math.pow (26, (title.length - 1 - i));
        }
        return result;
    }
}
