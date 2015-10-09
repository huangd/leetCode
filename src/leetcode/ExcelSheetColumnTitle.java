package leetcode;

/**
 * Created by huangd on 10/8/15.
 */
public class ExcelSheetColumnTitle {
    // TODO: there is a one off issue here.
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        while (n > 0) {
            int m = n % 26;
            title.append((char)m);
            n /= 26;
        }
        return title.reverse().toString();
    }
}
