package com.zhy.leetcode.contest.weeklycontest178.minimumcosttomakeatleastonevalidpathinagrid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minCost(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int[][] result = new int[grid.length][grid[0].length];
        for (int[] ints : result) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        result[result.length - 1][result[result.length - 1].length - 1] = 0;

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(result.length - 1, result[result.length - 1].length - 1));

        while (!queue.isEmpty()) {

            Position position = queue.poll();
            int x = position.x;
            int y = position.y;
            if (isValiud(grid, x + 1, y)) {
                int newRes = result[x][y] +(grid[x + 1][y] == 4? 0: 1);
                if (result[x + 1][y] > newRes) {
                    result[x + 1][y] = newRes;
                    queue.offer(new Position(x + 1, y));
                }
            }
            if (isValiud(grid, x - 1, y)) {
                int newRes = result[x][y] +(grid[x - 1][y] == 3? 0: 1);
                if (result[x - 1][y] > newRes) {
                    result[x - 1][y] = newRes;
                    queue.offer(new Position(x - 1, y));
                }
            }
            if (isValiud(grid, x, y + 1)) {
                int newRes = result[x][y] +(grid[x][y + 1] == 2? 0: 1);
                if (result[x][y + 1] > newRes) {
                    result[x][y + 1] = newRes;
                    queue.offer(new Position(x, y + 1));
                }
            }
            if (isValiud(grid, x, y - 1)) {
                int newRes = result[x][y] +(grid[x][y - 1] == 1? 0: 1);
                if (result[x][y - 1] > newRes) {
                    result[x][y - 1] = newRes;
                    queue.offer(new Position(x, y - 1));
                }
            }

        }
        return result[0][0];
    }

    private static class Position {

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;

        public int y;
    }

    private boolean isValiud(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[x].length;
    }
}