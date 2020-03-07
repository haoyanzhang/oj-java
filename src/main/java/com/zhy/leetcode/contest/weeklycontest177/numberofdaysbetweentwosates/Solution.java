package com.zhy.leetcode.contest.weeklycontest177.numberofdaysbetweentwosates;

import java.text.ParseException;

class Solution {

    public int daysBetweenDates(String date1, String date2) {
        Date d1 = parse(date1);
        Date d2 = parse(date2);
        return Math.abs(d1.sub(d2));

    }

    private Date parse(String s) {
        return new Date(Integer.valueOf(s.substring(0, 4)), Integer.valueOf(s.substring(5, 7)), Integer.valueOf(s.substring(8, 10)));
    }

    private static class Date {

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int sub(Date other) {
            return day() - other.day();
        }


        private static int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        private static int[] sumOfDay = new int[13];

        static {
            sumOfDay[0] = 0;
            for (int i = 1; i < sumOfDay.length; i++) {
                sumOfDay[i] = sumOfDay[i - 1] + dayOfMonth[i - 1];
            }
        }

        private int day() {
            return (year - 1970) * 365 + (year - 1970 + 1) / 4 + sumOfDay[month - 1] + day
                     + (year % 4 == 0 && year != 2100 && month >= 3? 1: 0);
        }

        public int year;

        public int month;

        public int day;
    }
}