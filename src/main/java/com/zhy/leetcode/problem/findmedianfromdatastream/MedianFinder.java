package com.zhy.leetcode.problem.findmedianfromdatastream;

import java.util.PriorityQueue;

/**
 * @author zhanghaoyan
 */
class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            Integer peek = maxHeap.peek();
            if (num > peek) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        }
    }

    public double findMedian() {
        while (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
        if (minHeap.size() != 0 && minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        }
        return 0;
    }
}
