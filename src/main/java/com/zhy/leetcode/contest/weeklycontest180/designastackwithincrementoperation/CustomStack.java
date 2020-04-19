package com.zhy.leetcode.contest.weeklycontest180.designastackwithincrementoperation;

import java.util.ArrayList;
import java.util.List;

class CustomStack {


    int[] data;
    int pos = 0;

    List<IncrementInfo> incrementInfos = new ArrayList<>();

    public CustomStack(int maxSize) {
        data = new int[maxSize];
    }

    public void push(int x) {
        if (pos == data.length) {
            return;
        }
        data[pos++] = x;
    }

    public int pop() {
        if (pos == 0) {
            return -1;
        }
        int datum = data[--pos];
        for (int i = 0; i < incrementInfos.size(); i++) {
            IncrementInfo incrementInfo = incrementInfos.get(i);
            if (incrementInfo.to == pos) {
                datum += incrementInfo.val;
                incrementInfo.to--;
            }
        }
        return datum;
    }

    public void increment(int k, int val) {
        incrementInfos.add(new IncrementInfo(Math.min(k - 1, pos - 1), val));
    }

    public static class IncrementInfo {

        public IncrementInfo(int to, int val) {
            this.to = to;
            this.val = val;
        }

        public int to;

        public int val;
    }
}