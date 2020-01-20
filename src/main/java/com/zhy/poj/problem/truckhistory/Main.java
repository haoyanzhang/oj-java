package com.zhy.poj.problem.truckhistory;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n;

        while ((n = scanner.nextInt()) != 0) {

            ArrayList<String> inputs = new ArrayList<String>(n);

            for (int i = 0; i < n; i++) {
                String next = scanner.next();
                inputs.add(next);
            }

            boolean[] exist = new boolean[n];
            int[] lowCost = new int[n];
            exist[0] = true;

            for (int i = 1; i < inputs.size(); i++) {
                lowCost[i] = dis(inputs.get(0), inputs.get(i));
            }

            int res = 0;
            for (int i = 1; i < n; i++) {
                int minIndex = 0;
                int min = Integer.MAX_VALUE;
                for (int j = 1; j < n; j++) {
                    if (!exist[j] && min > lowCost[j]) {
                        min = lowCost[j];
                        minIndex = j;
                    }
                }
                exist[minIndex] = true;
                res +=min;
                for (int j = 1; j < n; j++) {
                    if (!exist[j]) {
                        int dis = dis(inputs.get(minIndex), inputs.get(j));
                        if (lowCost[j] > dis) {
                            lowCost[j] = dis;
                        }
                    }
                }
            }

            System.out.println("The highest possible quality is 1/" + res + ".");


        }
    }

    private static int dis(String a, String b) {
        int r = 0;
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                r ++;
            }
        }
        return r;
    }

    private static class Node {

        public Node(int i, int j, int dis) {
            this.i = i;
            this.j = j;
            this.dis = dis;
        }

        public int i;
        public int j;
        public int dis;

    }
}
