package com.zhy.poj.problem.corralthecows;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        int c = cin.nextInt();
        int n = cin.nextInt();

        Point[] points = new Point[n];

        Set<Integer> indexSet = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            points[i] = new Point(cin.nextInt(), cin.nextInt());
            indexSet.add(points[i].x);
            indexSet.add(points[i].y);
        }

        indexSet.add(0);
        Integer[] indexArray = indexSet.toArray(new Integer[0]);
        Arrays.sort(indexArray);

        int[][] sum = new int[indexArray.length][indexArray.length];
        for (Point point : points) {
            sum[Arrays.binarySearch(indexArray, point.x)][Arrays.binarySearch(indexArray, point.y)]++;
        }
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[i].length; j++) {
                sum[i][j] = sum[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];

            }
        }

        int l = 1;
        int r = indexArray[indexArray.length - 1];
        while (l < r) {
            int mid = (r + l) >> 1;
            boolean ok = false;
            out:
            for (int i = 1; i < sum.length; i++) {
                for (int j = 1; j < sum[i].length; j++) {
                    int x = Arrays.binarySearch(indexArray, indexArray[i] + mid - 1);
                    if (x < 0) {
                        x = -x - 2;
                    }
                    int y = Arrays.binarySearch(indexArray, indexArray[j] + mid - 1);
                    if (y < 0) {
                        y = -y - 2;
                    }
                    if (sum[x][y] - sum[x][j - 1] - sum[i - 1][y] + sum[i - 1][j - 1] >= c) {
                        ok = true;
                        break out;
                    }
                    if (y == sum[i].length - 1) {
                        break;
                    }
                }
            }
            if (ok) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
