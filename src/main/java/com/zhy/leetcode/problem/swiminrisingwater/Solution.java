package com.zhy.leetcode.problem.swiminrisingwater;

import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {

        if (grid.length <= 1) {
            return 0;
        }
        int n = grid.length;
        int[][] result = new int[grid.length][grid[0].length];
        for (int[] array : result) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        result[0][0] = grid[0][0];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 1));
        queue.offer(new Point(1, 0));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int min = Integer.MAX_VALUE;
            List<Point> adjacentPoints = getAdjacentPoints(poll, n);
            for (Point adjacentPoint : adjacentPoints) {
                if (result[adjacentPoint.x][adjacentPoint.y] != Integer.MAX_VALUE) {
                    min = Math.min(min, result[adjacentPoint.x][adjacentPoint.y]);
                }
            }
            min = Math.max(min,grid[poll.x][poll.y]);
            if (min < result[poll.x][poll.y]) {
                result[poll.x][poll.y] = min;
                for (Point adjacentPoint : adjacentPoints) {
                    queue.offer(adjacentPoint);
                }
            }
        }
        return result[n-1][n-1];
    }

    private class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private List<Point> getAdjacentPoints(Point point, int n) {
        int x = point.x;
        int y = point.y;
        ArrayList<Point> res = new ArrayList<>();
        if (x >= 1) {
            res.add(new Point(x - 1, y));
        }
        if (x + 1 < n) {
            res.add(new Point(x + 1, y));
        }
        if (y >= 1) {
            res.add(new Point(x, y - 1));
        }
        if (y + 1 < n) {
            res.add(new Point(x, y + 1));
        }
        return res;
    }
}
