package com.zhy.leetcode.contest.biweeklycontest19.anglebetweenhandsofaclock;

class Solution {


    public double angleClock(int hour, int minutes) {

        double angleHour = 30D * (hour % 12) + 0.5D * minutes;
        double minuteHour = 6D * minutes;

        double result = angleHour - minuteHour;
        result = Math.abs(result);
        if (result > 180) {
            result = 360 - result;
        }
        return result;

    }
}