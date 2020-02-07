package com.zhy.leetcode.problem.lrucache;

import java.util.*;

class LRUCache {

    int capacity;

    LinkedHashMap<Integer, Integer> dataMap = new LinkedHashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (dataMap.containsKey(key)) {
            Integer value = dataMap.get(key);
            dataMap.remove(key);
            dataMap.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (dataMap.containsKey(key)) {
            dataMap.remove(key);
            dataMap.put(key, value);
        } else {
            if (dataMap.size() == capacity) {
                dataMap.remove(dataMap.keySet().iterator().next());
            }
            dataMap.put(key, value);
        }
    }


}

