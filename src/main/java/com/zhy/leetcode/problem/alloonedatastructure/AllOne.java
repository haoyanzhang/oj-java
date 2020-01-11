package com.zhy.leetcode.problem.alloonedatastructure;

import java.util.*;

class AllOne {

    /** Initialize your data structure here. */
    public AllOne() {
        hashMap = new HashMap<>();
        treeSet = new TreeSet<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair pair1, Pair pair2) {
                return pair1.getNum() - pair2.getNum() != 0? pair1.getNum() - pair2.getNum(): pair1.getKey().compareTo(pair2.getKey());
            }
        });
    }
    private HashMap<String, Pair> hashMap;
    private TreeSet<Pair> treeSet;

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Pair pair = hashMap.get(key);
        if (pair == null) {
            pair = new Pair(key, 1);
            hashMap.put(key, pair);
        } else {
            treeSet.remove(pair);
            pair.increase();
        }
        treeSet.add(pair);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Pair pair = hashMap.get(key);
        if (pair != null) {
            treeSet.remove(pair);
            pair.decrease();
            if (pair.isEmpty()) {
                hashMap.remove(key);
            } else {
                treeSet.add(pair);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (treeSet.isEmpty()) {
            return "";
        }
        return treeSet.last().key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (treeSet.isEmpty()) {
            return "";
        }
        return treeSet.first().key;
    }


    private static class Pair {

        public Pair(String key, Integer num) {
            this.key = key;
            this.num = num;
        }

        String key;

        Integer num;

        public void increase() {
            num++;
        }

        public void decrease() {
            if (num >= 1) {
                num--;
            }
        }

        public boolean isEmpty() {
            return  num <= 0;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */