package com.zhy.poj.problem.raid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseNum = scanner.nextInt();
        for (int i = 0; i < caseNum; i++) {
            int pair = scanner.nextInt();
            Point[] points = new Point[pair * 2];
            int pos = 0;
            for (int j = 0; j < pair; j++) {
                long x = scanner.nextLong();
                long y = scanner.nextLong();
                points[pos++] = new Point(x, y, 0);
            }
            for (int j = 0; j < pair; j++) {
                long x = scanner.nextLong();
                long y = scanner.nextLong();
                points[pos++] = new Point(x, y, 1);
            }
            Arrays.sort(points, new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    return p1.x < p2.x ? -1 : p1.x > p2.x ? 1 : 0;
                }
            });
            double v = minDistance(points, 0, points.length);
            System.out.println(String.format("%.3f", v));
        }
    }

    private static double minDistance(Point[] points, int start, int end) {
        if (end - start <= 2) {
            return end - start ==2 ? points[start].distance(points[start + 1]) : Double.MAX_VALUE;
        } else {
            int mid = (start + end) >> 1;
            double min = Math.min(minDistance(points, start, mid), minDistance(points, mid, end));
            int startPos = mid;
            int endPos = mid + 1;
            while (startPos > start && points[mid].x - points[startPos - 1].x < min) {
                startPos--;
            }
            while (endPos < end && points[endPos].x - points[mid].x < min) {
                endPos++;
            }
            Point[] ps = Arrays.copyOfRange(points, startPos, endPos);
            Arrays.sort(ps, new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    return p1.y < p2.y ? -1 : p1.y > p2.y ? 1 : 0;
                }
            });

            for (int j = 0; j < ps.length; j++) {
                for (int k = j + 1; k < ps.length; k++) {
                    if (ps[k].y - ps[j].y > min) {
                        break;
                    }
                    min = Math.min(min, ps[j].distance(ps[k]));
                }
            }
            return min;
        }
    }

    private static class Point {

        public Long x;

        public Long y;

        public Integer type;

        public Point(Long x, Long y, Integer type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        public double distance(Point o) {
            if (type.equals(o.type)) {
                return Double.MAX_VALUE;
            } else {
                return Math.sqrt((x - o.x) * (x - o.x) + (y - o.y) * (y - o.y));
            }
        }
    }
}
