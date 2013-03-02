package leetcode;

/**
 * User: huangd
 * Date: 3/1/13
 * Time: 10:26 PM
 */
public class CountAndSay {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String current = "1";
        for (int i = 1; i < n; ++i) {
            current = getNext(current);
        }
        return current;
    }

    private String getNext(String current) {
        StringBuilder stringBuilder = new StringBuilder();
        char base = ' ';
        int repeat = 0;
        for (int i = 0; i < current.length(); ++i) {
            if (base == ' ' || current.charAt(i) == base) {
                repeat++;
            } else {
                stringBuilder.append(repeat).append(base);
                repeat = 1;
            }
            base = current.charAt(i);
        }
        stringBuilder.append(repeat).append(base);
        return stringBuilder.toString();
    }
}
