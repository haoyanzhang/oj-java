package com.zhy.leetcode.problem.frogjump;

/**
 * @author zhanghaoyan
 */
class Solution {

    public boolean canCross(int[] stones) {

        if (stones.length == 0) {
            return false;
        }
        if (stones.length == 1) {
            return true;
        }
        if (stones[1] != 1) {
            return false;
        }
        return dfs(stones, 1, 1, new boolean[stones.length][stones.length]);
    }

    public boolean dfs(int[] stones, int pos, int lastJump, boolean[][] jumped) {
        if (pos == stones.length - 1) {
            return true;
        }
        boolean result = false;
        int nextPos = pos + 1;
        while (!result && nextPos < stones.length && stones[nextPos] - stones[pos] <= lastJump + 1) {
            int next = stones[nextPos] - stones[pos];
            if (!jumped[pos][nextPos] && Math.abs(next - lastJump) <=1) {
                jumped[pos][nextPos] = true;
                result = dfs(stones, nextPos, next, jumped);
            }
            nextPos++;
        }
        return result;
    }
}
