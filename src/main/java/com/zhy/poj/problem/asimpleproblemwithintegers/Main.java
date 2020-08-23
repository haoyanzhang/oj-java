package com.zhy.poj.problem.asimpleproblemwithintegers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        long[] data = new long[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextLong();
        }
        SegmentTree segmentTree = new SegmentTree(data);
        for (int i = 0; i < t; i++) {
            String next = scanner.next();
            if (next.equals("Q")) {
                int l = scanner.nextInt() - 1;
                int r = scanner.nextInt() - 1;
                System.out.println(segmentTree.query(l, r));
            } else {
                int l = scanner.nextInt() - 1;
                int r = scanner.nextInt() - 1;
                long v = scanner.nextLong();
                segmentTree.add(l, r, v);
            }
        }
    }

    private static class SegmentTree {

        long[] sum;
        long[] left;
        long[] right;
        long[] lazyAdd;

        public SegmentTree(long[] data) {
            sum = new long[data.length * 4];
            left = new long[data.length * 4];
            right = new long[data.length * 4];
            lazyAdd = new long[data.length * 4];
            Arrays.fill(lazyAdd, 0);
            build(data, 1, 0, data.length - 1);
        }

        private long build(long[] data, int p, int l, int r) {
            left[p] = l;
            right[p] = r;
            if (l == r) {
                return sum[p] = data[l];
            } else {
                int mid = (r + l) >> 1;
                return sum[p] = build(data, 2 * p, l, mid) + build(data, 2 * p + 1, mid + 1, r);
            }
        }

        public void add(int l, int r, long value) {
            add(1, l, r, value);
        }

        public long add(int p, int l, int r, long value) {
            if (left[p] > r || right[p] < l) {
                return 0;
            } else if (left[p] >= l && right[p] <= r) {
                lazyAdd[p] += value;
                return value * (right[p] - left[p] + 1);
            } else {
                long i = add(p * 2, l, r, value) + add(p * 2 + 1, l, r, value);
                sum[p] += i;
                return i;
            }
        }

        public long query(int l, int r) {
            return query(1, l, r);
        }

        private long query(int p, int l, int r) {
            if (left[p] > r || right[p] < l) {
                return 0;
            } else if (left[p] >= l && right[p] <= r) {
                return sum[p] + lazyAdd[p] * (right[p] - left[p] + 1);
            } else {
                if (lazyAdd[p] != 0) {
                    sum[p] += add(2 * p, 0, Integer.MAX_VALUE, lazyAdd[p]) + add(2 * p + 1, 0, Integer.MAX_VALUE, lazyAdd[p]);
                    lazyAdd[p] = 0;
                }
                return query(p * 2, l, r) + query(p * 2 + 1, l, r);
            }
        }
    }
}
