package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 11:13 PM
 */
public class WordLadder {

    private HashMap<String, Integer> wordDistance;
    private HashSet<String> wordDiscover;

    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        wordDistance = new HashMap<String, Integer>();
        wordDiscover = new HashSet<String>();
        return bfs(start, end, dict);
    }

    public int bfs(String start, String end, HashSet<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        wordDistance.put(start, 1);
        wordDiscover.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (isOffOneLetter(word, end)) {
                return wordDistance.get(word) + 1;
            } else {
                for (int i = 0; i < end.length(); ++i) {
                    for (int c = 'a'; c <= 'z'; ++c) {
                        String nextWord = replaceChar((char) c, i, word);
                        if (dict.contains(nextWord) && !wordDiscover.contains(nextWord)) {
                            wordDistance.put(nextWord, wordDistance.get(word) + 1);
                            wordDiscover.add(nextWord);
                            queue.add(nextWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    private String replaceChar(char c, int index, String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        stringBuilder.setCharAt(index, c);
        return stringBuilder.toString();
    }

    private boolean isOffOneLetter(String word, String end) {
        int diff = 0;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) != end.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
