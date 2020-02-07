package com.zhy.leetcode.problem.LFUcache;

import java.util.*;

/**
 * @author zhanghaoyan
 */
class LFUCache {

    int capacity;

    Map<Integer, Integer> dataMap = new HashMap<>();

    Map<Integer, Integer> keyTimeMap = new HashMap<>();

    TreeMap<Integer, LinkedList<Integer>> timeKeyMap = new TreeMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (dataMap.containsKey(key)) {
            addUseTime(key);
            return dataMap.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (dataMap.containsKey(key)) {
            addUseTime(key);
            dataMap.put(key, value);
        } else {
            if (dataMap.size() == capacity) {
                removeLeastUseKey();
            }
            dataMap.put(key, value);
            keyTimeMap.put(key, 1);
            timeKeyMap.computeIfAbsent(1, (k) -> new LinkedList<>());
            timeKeyMap.get(1).add(key);
        }
    }

    private void addUseTime(int key) {
        Integer time = keyTimeMap.get(key);
        keyTimeMap.put(key, time + 1);
        LinkedList<Integer> curTimeList = timeKeyMap.get(time);
        if (curTimeList.size() == 1) {
            timeKeyMap.remove(time);
        } else {
            curTimeList.remove(Integer.valueOf(key));
        }
        timeKeyMap.computeIfAbsent(time + 1, (k) -> new LinkedList<>());
        timeKeyMap.get(time + 1).add(key);
    }

    private void removeLeastUseKey() {
        Integer leastTime = timeKeyMap.firstKey();
        LinkedList<Integer> leastTimeList = timeKeyMap.get(leastTime);
        Integer key = leastTimeList.pollFirst();
        if (leastTimeList.size() == 0) {
            timeKeyMap.remove(leastTime);
        }
        keyTimeMap.remove(key);
        dataMap.remove(key);
    }
}

