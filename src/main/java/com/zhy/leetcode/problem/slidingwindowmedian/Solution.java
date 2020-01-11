package com.zhy.leetcode.problem.slidingwindowmedian;

import java.util.*;

/**
 * @author zhanghaoyan
 */
class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];
        int pos = 0;

        //big
        MySet set1 = new MySet();
        //small
        MySet set2 = new MySet();
        for (int i = 0; i < nums.length; i++) {
            if (set1.size() == 0 && set2.size() == 0) {
                set1.add((long)nums[i]);
            } else if ((set1.size() != 0 && nums[i] > set1.first()) || (set2.size() != 0 && nums[i] > set2.last())) {
                set1.add((long)nums[i]);
            } else {
                set2.add((long)nums[i]);
            }
            if (i >= k - 1) {
                while (set1.size() > set2.size() + 1) {
                    long first = set1.first();
                    set2.add(first);
                    set1.remove(first);
                }
                while (set1.size() < set2.size()) {
                    long last = set2.last();
                    set1.add(last);
                    set2.remove(last);
                }
                result[pos++] = k % 2 == 1? set1.first(): ((double)(set1.first() + set2.last()) / 2);
                if (nums[i - k + 1] >= set1.first()) {
                    set1.remove((long)nums[i - k + 1]);
                } else {
                    set2.remove((long)nums[i - k + 1]);
                }
            }
        }

        return result;
    }

    private class MySet {
        private TreeMap<Long, Long> treeMap = new TreeMap<Long, Long>();

        int size=0;

        public int size() {
            return size;
        }

        public void add(Long i) {
            size++;
            if (treeMap.containsKey(i)) {
                treeMap.put(i, treeMap.get(i) + 1);
            } else {
                treeMap.put(i, 1L);
            }
        }

        public void remove(Long i) {
            size--;
            Long num = treeMap.get(i);
            if (num > 1) {
                treeMap.put(i, num - 1);
            } else {
                treeMap.remove(i);
            }
        }

        public Long first(){
            return treeMap.firstKey();
        }

        public Long last(){
            return treeMap.lastKey();
        }
    }


}
