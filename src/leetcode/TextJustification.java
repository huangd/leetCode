package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 11:13 AM
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> justifiedText = new ArrayList<String>();
        boolean isFirstWord = true;
        int lineStartIndex = 0;
        int spaceUsed = 0;
        for (int i = 0; i < words.length; ++i) {
            if (isFirstWord) {
                lineStartIndex = i;
                isFirstWord = false;
                spaceUsed += words[i].length();
            } else {
                if (spaceUsed + words[i].length() + 1 <= L) {
                    spaceUsed += words[i].length() + 1;
                } else {
                    justifiedText.add(justifyALine(Arrays.copyOfRange(words, lineStartIndex, i), L));
                    isFirstWord = true;
                    spaceUsed = 0;
                    --i;
                }
            }
        }
        justifiedText.add(justifyLastLine(Arrays.copyOfRange(words, lineStartIndex, words.length), L));
        return justifiedText;
    }

    private String justifyALine(String[] words, int L) {
        for (String word : words) {
            L -= word.length();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(words[0]);
        if (words.length == 1) {
            return stringBuilder.append(getSpace(L)).toString();
        } else {
            int minGap = L / (words.length - 1);
            int mod = L % (words.length - 1);
            for (int i = 1; i < words.length; ++i, --mod) {
                if (mod > 0) {
                    stringBuilder.append(getSpace(minGap + 1)).append(words[i]);
                } else {
                    stringBuilder.append(getSpace(minGap)).append(words[i]);
                }
            }
            return stringBuilder.toString();
        }
    }

    private String justifyLastLine(String[] words, int L) {
        StringBuilder lastLine = new StringBuilder();
        lastLine.append(words[0]);
        L -= words[0].length();
        for (int i = 1; i < words.length; ++i) {
            lastLine.append(" " + words[i]);
            L -= (words[i].length() + 1);
        }
        return lastLine.append(getSpace(L)).toString();
    }

    private String getSpace(int n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
