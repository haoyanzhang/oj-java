package com.zhy.leetcode.problem.trappingrainwaterII;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhanghaoyan
 */
class Solution {

    public int trapRainWater(int[][] heightMap) {

        if (heightMap.length == 0) {
            return  0;
        }

        Queue<Point> points = new PriorityQueue<>();

        for (int i = 0; i < heightMap.length; i++) {
            points.add(new Point(i, 0, heightMap[i][0]));
            points.add(new Point(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
        }
        for (int i = 0; i < heightMap[0].length; i++) {
            points.add(new Point(0, i, heightMap[0][i]));
            points.add(new Point(heightMap.length - 1, i, heightMap[heightMap.length - 1][i]));
        }

        boolean[][] reached = new boolean[heightMap.length][heightMap[0].length];
        int result = 0;

        while (!points.isEmpty()) {
            result += travel(points.poll(), heightMap, reached, points);
        }


        return result;
    }

    private int travel(Point point ,int[][] heightMap, boolean[][] reached, Queue<Point> points) {
        int i = point.getI();
        int j = point.getJ();
        int height = point.getHeight();
        if (i < 0 || j < 0 || i >= heightMap.length || j >= heightMap[0].length || reached[i][j]) {
            return 0;
        }
        if (height >= heightMap[i][j]) {
            reached[i][j] = true;
            return height - heightMap[i][j] + travel(new Point(i + 1, j, height), heightMap, reached, points)
                    + travel(new Point(i - 1, j, height), heightMap, reached, points)
                    + travel(new Point(i, j + 1, height), heightMap, reached, points)
                    + travel(new Point(i, j - 1, height), heightMap, reached, points);
        }
        points.offer(new Point(i, j, heightMap[i][j]));
        return 0;
    }

    private static class Point implements Comparable<Point> {

        public Point(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        int i;

        int j;

        int height;

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Point o) {
            return this.height - o.height;
        }
    }
}
