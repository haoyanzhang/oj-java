package com.zhy.leetcode.problem.LFUcache;

import java.util.*;

/**
 * @author zhanghaoyan
 */
class LFUCache {

    private int capacity;

    private Map<Integer, Integer> keyValueMap = new HashMap<>();
    private Map<Integer, Integer> keyFreqMap = new HashMap<>();
    private Map<Integer, LinkedList<Integer>> freqKeyMap = new HashMap<>();
    private int minFreq = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = keyValueMap.get(key);
        if (value == null) {
            return  -1;
        }
        Integer freq = keyFreqMap.get(key);
        keyFreqMap.put(key, freq + 1);
        freqKeyMap.get(freq).remove(((Integer) key));
        LinkedList<Integer> keyLists = freqKeyMap.computeIfAbsent(freq + 1, k -> new LinkedList<>());
        keyLists.add(key);
        if (minFreq == freq && freqKeyMap.get(freq).isEmpty()) {
            minFreq = freq + 1;
        }
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!keyValueMap.containsKey(key)) {
            keyValueMap.put(key, value);
            keyFreqMap.put(key, 1);
            LinkedList<Integer> keyLists = freqKeyMap.computeIfAbsent(1, k -> new LinkedList<>());
            keyLists.add(key);
            if (keyValueMap.keySet().size() > capacity) {
                Integer removeKey = freqKeyMap.get(minFreq).pollFirst();
                keyFreqMap.remove(removeKey);
                keyValueMap.remove(removeKey);
            }
            minFreq = 1;
        } else {
            keyValueMap.put(key, value);
            Integer freq = keyFreqMap.get(key);
            keyFreqMap.put(key, freq + 1);
            freqKeyMap.get(freq).remove(((Integer) key));
            LinkedList<Integer> keyLists = freqKeyMap.computeIfAbsent(freq + 1, k -> new LinkedList<>());
            keyLists.add(key);
            if (minFreq == freq && freqKeyMap.get(freq).isEmpty()) {
                minFreq = freq + 1;
            }
        }
    }
}
