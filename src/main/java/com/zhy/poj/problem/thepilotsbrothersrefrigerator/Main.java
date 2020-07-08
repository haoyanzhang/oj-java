package com.zhy.poj.problem.thepilotsbrothersrefrigerator;

import java.util.Scanner;

public class Main {

    private static int[] column = new int[]{0x8888, 0x4444, 0x2222, 0x1111};
    private static int[] row = new int[]{0xF000, 0x0F00, 0x00F0, 0x000F};

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int state = 0;
        for (int i =0; i< 4; i++) {
            String line = scanner.next();
            for (int j = 0; j < line.toCharArray().length; j++) {
                if (line.toCharArray()[j] == '+') {
                    state = move(state, i, j);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int c = 0;
        for (int i =0; i< 16; i++) {
            if ((state & (1 << i)) > 0) {
                int index = 15 - i;
                stringBuilder.append("\n").append(index / 4 + 1).append(" ").append(index % 4 + 1);
                c++;
            }
        }
        System.out.println(c + stringBuilder.toString());
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int move(int state, int i, int j) {
        return state ^ column[j] ^ row[i] ^ (1 << ((3 - i) * 4 + (3 - j)));
    }
}
