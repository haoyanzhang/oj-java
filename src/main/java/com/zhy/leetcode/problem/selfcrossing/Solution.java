package com.zhy.leetcode.problem.selfcrossing;

class Solution {


    public boolean isSelfCrossing(int[] x) {

        if (x.length == 0) {
            return false;
        }

        Point[] points = new Point[x.length + 1];
        points[0] = new Point(0, 0);

        for (int i = 0; i < x.length; i++) {
            points[i + 1] = points[i].move(i, x[i]);
            int cur = i - 3;
            while (cur >= 0) {
                if (isCross(points[cur], points[cur+1], points[i], points[i+1])) {
                    return true;
                }
                cur -= 2;
            }
        }

        return points[points.length-1].x == 0 && points[points.length-1].y == 0;

    }

    private boolean isCross(Point p1, Point p2, Point p3, Point p4) {
        if (p1.x == p2.x) {
            return isBetween(p1.x, p3.x, p4.x) && isBetween(p3.y, p1.y, p2.y);
        }  else {
            return isBetween(p1.y, p3.y, p4.y) && isBetween(p3.x, p1.x, p2.x);
        }
    }

    private boolean isBetween(int i, int r, int l) {
        return i <= r && i >= l || i >= r && i <= l;
    }

    private static class Point {

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;

        public int y;

        public Point move(int i, int length) {
            switch (i % 4) {
                case 0: return new Point(x, y + length);
                case 1: return new Point(x - length, y);
                case 2: return new Point(x, y - length);
                case 3: return new Point(x + length, y);
            }
            return null;
        }
    }
}
