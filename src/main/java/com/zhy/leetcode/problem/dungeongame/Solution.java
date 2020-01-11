package com.zhy.leetcode.problem.dungeongame;



class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 1;
        }
        for (int i = dungeon.length - 1; i >= 0; i--) {
            for (int j = dungeon[i].length - 1; j >= 0; j--) {
                if (i == dungeon.length - 1) {
                    if (j == dungeon[i].length - 1) {
                        dungeon[i][j] = ensureAtLeastOne(1 - dungeon[i][j]);
                    } else {
                        dungeon[i][j] = ensureAtLeastOne(dungeon[i][j + 1] - dungeon[i][j]);
                    }
                } else if (j == dungeon[i].length - 1) {
                    dungeon[i][j] = ensureAtLeastOne(dungeon[i+1][j] - dungeon[i][j]);
                } else {
                    dungeon[i][j] = ensureAtLeastOne(Math.min(dungeon[i+1][j] - dungeon[i][j], dungeon[i][j+1] - dungeon[i][j]));
                }
            }
        }
        return dungeon[0][0];
    }

    private int ensureAtLeastOne(int i) {
        return i < 1? 1: i;
    }


}