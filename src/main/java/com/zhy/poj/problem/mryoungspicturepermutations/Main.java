package com.zhy.poj.problem.mryoungspicturepermutations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt()) != 0) {
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextInt();
            }
            Map<String, Long> dp = new HashMap<String, Long>();
            dp.put(key(new int[n]), 1L);
            System.out.println(dfs(input, dp));
        }

    }

    private static Long dfs(int[] input, Map<String, Long> dp) {
        String key = key(input);
        if (dp.containsKey(key)) {
            return dp.get(key);
        } else {
            long res = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] >= 1 && (i == input.length - 1 || input[i] > input[i + 1])) {
                    input[i]--;
                    res += dfs(input, dp);
                    input[i]++;
                }
            }
            dp.put(key, res);
            return res;
        }
    }

    private static String key(int[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            stringBuilder.append(input[i]).append(".");
        }
        return stringBuilder.toString();
    }
}
