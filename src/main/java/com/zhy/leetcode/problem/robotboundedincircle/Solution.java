package com.zhy.leetcode.problem.robotboundedincircle;

class Solution {
    public boolean isRobotBounded(String instructions) {

        int x = 0;
        int y = 0;
        int i = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                i++;
            } else if (c == 'R') {
                i--;
            } else {
                int dir = Math.abs(i) % 4;
                if (dir == 0) {
                    y += 1;
                } else if (dir == 1) {
                    x -= 1;
                } else if (dir == 2) {
                    y -= 1;
                } else {
                    x += 1;
                }
            }
        }
        return  i%4 !=0 || (x == y && x == 0);
    }

}
