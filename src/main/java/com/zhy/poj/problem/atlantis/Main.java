package com.zhy.poj.problem.atlantis;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n;

        int testCase = 1;
        while ((n = scanner.nextInt()) != 0) {

            double[][] input = new double[n][4];

            TreeSet<Double> ys = new TreeSet<Double>();

            for (int i = 0; i < n; i++) {
                input[i][0] = scanner.nextFloat();
                input[i][1] = scanner.nextFloat();
                input[i][2] = scanner.nextFloat();
                input[i][3] = scanner.nextFloat();
                ys.add(input[i][1]);
                ys.add(input[i][3]);
            }

            double[] val = new double[ys.size()];
            HashMap<Double, Integer> index = new HashMap<Double, Integer>();
            int i = 0;
            for (double y : ys) {
                val[i] = y;
                index.put(y, i);
                i++;
            }

            Line[] lines = new Line[2 * n];
            for (int j = 0; j < input.length; j++) {
                double[] rectangle = input[j];
                lines[2 * j] = new Line(rectangle[0], index.get(rectangle[1]), index.get(rectangle[3]), 1);
                lines[2 * j + 1] = new Line(rectangle[2], index.get(rectangle[1]), index.get(rectangle[3]), -1);
            }

            Arrays.sort(lines, new Comparator<Line>() {
                @Override
                public int compare(Line l1, Line l2) {
                    return Double.compare(l1.x, l2.x);
                }
            });

            double res = 0;
            SegmentTree segmentTree = new SegmentTree(val);
            for (int j = 0; j < lines.length; j++) {
                Line line = lines[j];
                segmentTree.add(line.y1, line.y2, line.val);
                if (j + 1 < lines.length) {
                    res += segmentTree.query() * (lines[j + 1].x - line.x);
                }
            }

            System.out.println("Test case #" + testCase);
            testCase++;
            System.out.println("Total explored area: " + String.format("%.2f", res));
            System.out.println();
        }
    }

    private static class Line {

        public double x;

        public int y1;

        public int y2;

        public int val;

        public Line(double x, int y1, int y2, int val) {
            this.x = x;
            this.y1 = y1;
            this.y2 = y2;
            this.val = val;
        }
    }

    private static class SegmentTree {

        Data[] data;

        private static class Data {

            public int l;

            public int r;

            public double length;

            public int val;

            public Data(int l, int r, double length, int val) {
                this.l = l;
                this.r = r;
                this.length = length;
                this.val = val;
            }
        }

        public SegmentTree(double[] val) {
            data = new Data[4 * val.length];
            init(1, 0, val.length - 1, val);
        }

        private double init(int index, int l, int r, double[] val) {
            double length = 0;
            if (r - l > 1) {
                int mid = (l + r) >> 1;
                length += init(2 * index, l, mid, val);
                length += init(2 * index + 1, mid, r, val);
            } else {
                length += val[r] - val[l];
            }
            data[index] = new Data(l, r, length, 0);
            return length;
        }

        public void add(int from, int to, int val) {
            add(from, to, val, 1);
        }

        private void add(int from, int to, int val, int index) {
            if (data[index] == null) {
                return;
            }
            if (from <= data[index].l && to >= data[index].r) {
                data[index].val += val;
            } else if (from > data[index].r || to < data[index].l) {
                return;
            } else if (data[index].r - data[index].l > 1) {
                add(from, to, val, index * 2);
                add(from, to, val, index * 2 + 1);
            }
        }

        public double query() {
            return query(1);
        }

        public double query(int index) {
            if (data[index] == null) {
                return 0;
            }
            if (data[index].val > 0) {
                return data[index].length;
            } else if (data[index].r - data[index].l != 1) {
                return query(2 * index) + query(2 * index + 1);
            } else {
                return 0;
            }
        }

    }


}
