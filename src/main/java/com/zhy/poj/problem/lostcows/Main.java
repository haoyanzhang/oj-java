package com.zhy.poj.problem.lostcows;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        int[] heights = new int[n];
        data[0] = 0;
        for (int i = 1; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        Bit bit = new Bit(n);
        for (int i = 1; i <= n; i++) {
            bit.add(i, 1);
        }
        for (int i = data.length - 1; i >= 0; i--) {
            int target = data[i] + 1;
            int index = 1;
            int l = 1;
            while (l > 0) {
                int ask = bit.ask(index + l - 1);
                if(ask >= target) {
                    l = l >> 1;
                } else {
                    index += l;
                    l = l << 1;
                }
            }
            bit.add(index, -1);
            heights[i] = index;
        }
        for (int height : heights) {
            System.out.println(height);
        }
    }

    public static class Bit {

        int[] data;

        Bit(int n) {
            data = new int[n + 1];
        }

        private int lowBit(int i) {
            return i & -i;
        }

        public void add(int index, int value) {
            while (index < data.length) {
                data[index] += value;
                index += lowBit(index);
            }
        }

        public int ask(int n) {
            if (n >= data.length) {
                return ask(data.length - 1);
            }
            int result = 0;
            while (n > 0) {
                result += data[n];
                n = n - lowBit(n);
            }
            return result;
        }
    }
}
