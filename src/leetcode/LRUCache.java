package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: huangd
 * Date: 4/4/13
 * Time: 8:42 PM
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int MAX_ENTRY;

    public LRUCache(int size) {
        MAX_ENTRY = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRY;
    }
}
