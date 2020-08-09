package com.zhy.ch.problem.shortesthamiltonpath;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] =scanner.nextInt();
            }
        }
        int[][] f = new int[1<<n][n];
        for (int[] ints : f) {
            Arrays.fill(ints,0x3f3f3f3f);
        }
        f[1][0] = 0;
        for (int i = 1; i < 1<<n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    for (int k = 0; k < n; k++) {
                        if (((i >> k) & 1) > 0 && j != k) {
                            f[i][j] = Math.min(f[i][j], f[i ^ (1 << j)][k] + g[k][j]);
                        }
                    }
                }
            }
        }
        System.out.println(f[f.length - 1][n - 1]);
    }
}
