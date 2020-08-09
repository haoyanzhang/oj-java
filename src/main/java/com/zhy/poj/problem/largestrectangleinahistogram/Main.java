package com.zhy.poj.problem.largestrectangleinahistogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n;
        while ((n = scanner.nextInt()) != 0) {

            List<Long> stack = new ArrayList<Long>(n);
            List<Long> width = new ArrayList<Long>(n);

            long result = 0;

            for (int i = 0; i < n; i++) {
                long input = scanner.nextLong();
                long w = 0;
                while (!stack.isEmpty() && stack.get(stack.size() - 1) >= input) {
                    Long last = stack.get(stack.size() - 1);
                    w += width.get(width.size() - 1);
                    result = Math.max(result, last * w);
                    stack.remove(stack.size() - 1);
                    width.remove(width.size() - 1);
                }
                stack.add(input);
                width.add(w + 1);
            }
            long w = 0;
            while (!stack.isEmpty()) {
                Long last = stack.get(stack.size() - 1);
                w += width.get(width.size() - 1);
                result = Math.max(result, last * w);
                stack.remove(stack.size() - 1);
                width.remove(width.size() - 1);
            }
            System.out.println(result);
        }
    }
}
