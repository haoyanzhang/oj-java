package com.zhy.poj.problem.bestcowfences;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt() * 1000;
        }
        int l = 0;
        int r = 2000 * 1000;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (isOk(mid, h, length)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l - 1);
    }
    public static boolean isOk(int mid, int[] h ,int length) {
        long[] sum = new long[h.length];
        long preMin = 0;
        sum[0] = h[0] - mid;
        if (length == 1 && sum[0] >= 0) {
            return true;
        }
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + h[i] - mid;
            if (i - length > 0) {
                preMin = Math.min(preMin, sum[i - length]);
            }
            if(sum[i] - preMin >= 0) {
                return true;
            }
        }
        return false;
    }
}
