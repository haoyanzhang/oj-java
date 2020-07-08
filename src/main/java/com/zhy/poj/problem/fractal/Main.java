package com.zhy.poj.problem.fractal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int i = scanner.nextInt();
            if (i == -1) {
                return;
            }
            int w = 1;
            for (int j = 1; j < i; j ++) {
                w *= 3;
            }
            int[][] g = new int[w][w];
            dfs(g, 0, 0, w);
            for (int m = 0; m < g.length; m++) {
                for (int n = 0; n < g[m].length; n++) {
                    if (g[m][n] == 1) {
                        System.out.print("X");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
            }
            System.out.println("-");
        }
    }

    private static void dfs(int[][] g, int x, int y, int w) {
        if (w == 1) {
            g[x][y] = 1;
        } else {
            int nextW = w / 3;
            dfs(g, x, y, nextW);
            dfs(g, x + 2 * nextW, y, nextW);
            dfs(g, x + nextW, y + nextW, nextW);
            dfs(g, x,  y + 2 * nextW, nextW);
            dfs(g, x + 2 * nextW, y + 2 * nextW, nextW);
        }
    }
}
