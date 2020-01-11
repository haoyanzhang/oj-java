package com.zhy.leetcode.problem.insertdeletegetrandomo1duplicatesallowed;


import java.util.*;

class RandomizedCollection {


    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> value = map.get(val);

        if (value == null) {
            map.put(val, new HashSet<>());
            map.get(val).add(list.size());
            list.add(val);
            return true;
        } else {
            value.add(list.size());
            list.add(val);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> value = map.get(val);
        if (value == null) {
            return false;
        } else {
            Integer toRemove = value.iterator().next();
            if (value.size() == 1) {
                map.remove(val);
            } else {
                value.remove(toRemove);
            }
            if (toRemove != list.size() - 1) {
                list.set(toRemove, list.get(list.size() - 1));
                Set<Integer> lastEleSet = map.get(list.get(list.size() - 1));
                lastEleSet.remove(list.size() - 1);
                lastEleSet.add(toRemove);
            }
            list.remove(list.size() - 1);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
