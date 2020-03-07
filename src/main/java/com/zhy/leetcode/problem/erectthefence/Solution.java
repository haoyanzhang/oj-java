package com.zhy.leetcode.problem.erectthefence;

import java.util.*;

class Solution {

    public int[][] outerTrees(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        Stack<int[]> top = new Stack<int[]>();
        Stack<int[]> bottom = new Stack<int[]>();

        int pos = 0;
        while (pos < points.length) {
            int[] lastPoint = points[pos];
            pos++;
            while (pos < points.length && points[pos][0] == lastPoint[0]) {
                pos++;
            }
            int[] firstPoint = points[pos - 1];


            while (top.size() >= 2) {
                int[] topElement = top.pop();
                if (calK(firstPoint, topElement) - calK(topElement, top.peek()) < 1e-5) {
                    top.push(topElement);
                    break;
                }
            }
            top.push(firstPoint);

            while (bottom.size() >= 2) {
                int[] topElement = bottom.pop();
                if (calK(lastPoint, topElement) - calK(topElement, bottom.peek()) > -1e-5) {
                    bottom.push(topElement);
                    break;
                }
            }
            bottom.push(lastPoint);

        }

        List<int[]> result = new ArrayList<>();

        for (int i = 1; i + 1 < points.length; i++) {
            if (points[i][0] == points[0][0] && points[i + 1][0] == points[0][0]) {
                result.add(points[i]);
            }
        }
        if (points[0][0] != points[points.length - 1][0]) {
            for (int i = points.length - 2; i >= 1; i--) {
                if (points[i][0] == points[points.length - 1][0] && points[i - 1][0] == points[points.length - 1][0]) {
                    result.add(points[i]);
                }
            }
        }

        while (true) {
            if (top.isEmpty()) {
                result.addAll(bottom);
                break;
            } else if (bottom.isEmpty()) {
                result.addAll(top);
                break;
            }
            int[] t = top.peek();
            int[] b = bottom.peek();
            if (t[0] == b[0]) {
                if (t[1] == b[1]) {
                    result.add(t);
                    top.pop();
                    bottom.pop();
                } else {
                    result.add(top.pop());
                    result.add(bottom.pop());
                }
            } else if (t[0] > b[1]) {
                result.add(top.pop());
            } else {
                result.add(bottom.pop());
            }
        }
        int[][] ints = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

    private double calK(int[] a, int[] b) {
        return (b[1] - a[1]) / (double)(b[0] - a[0]);
    }
}
