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
            current = countAndSay(current);
        }
        return current;
    }

    private String countAndSay(String input) {
        char letter = input.charAt(0);
        int count = 0;
        StringBuilder say = new StringBuilder();
        for(char c : input.toCharArray()) {
            if (letter == c) {
                count++;
            } else {
                say.append(count).append(letter);
                letter = c;
                count = 1;
            }
        }
        say.append(count).append(letter);
        return say.toString();
    }
}
