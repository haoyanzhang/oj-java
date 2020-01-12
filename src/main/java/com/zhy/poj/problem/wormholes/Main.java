package com.zhy.poj.problem.wormholes;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int f = scanner.nextInt();
        for (int i = 0; i < f; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int w = scanner.nextInt();
            int[][] path = new int[n][n];
            for (int[] line : path) {
                Arrays.fill(line, Integer.MAX_VALUE);
            }
            for (int j = 0; j < m; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int l = scanner.nextInt();
                if (path[a-1][b-1] >= l) {
                    path[a-1][b-1] = path[b-1][a-1] = l;
                }
            }
            for (int j = 0; j < w; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int l = scanner.nextInt();
                path[a-1][b-1] = -l;
            }
            if(spfa(path)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    public static boolean spfa(int[][] path) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        int[] time = new int[path.length];
        queue.offer(0);
        set.add(0);
        int[] length = new int[path.length];
        Arrays.fill(length, Integer.MAX_VALUE);
        length[0] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            set.remove(poll);
            for (int i = 0; i < length.length; i++) {
                if (path[poll][i] != Integer.MAX_VALUE && length[i] > length[poll] + path[poll][i]) {
                    length[i] = length[poll] + path[poll][i];
                    if (!set.contains(i)) {
                        time[poll] ++;
                        if (time[poll] >= path.length) {
                            return true;
                        }
                        queue.offer(i);
                        set.add(i);
                    }
                }
            }
        }
        return false;
    }
}
