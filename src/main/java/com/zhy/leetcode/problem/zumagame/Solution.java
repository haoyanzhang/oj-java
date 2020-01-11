package com.zhy.leetcode.problem.zumagame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int findMinStep(String board, String hand) {

        int[] handArray = new int[5];
        for (char c : hand.toCharArray()) {
            handArray[colorToInt(c)] ++;
        }


        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(board, 0, handArray));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            int[] stateHand = state.getHand();
            String stateBoard = state.getBoard();
            int stateTime = state.getTime();
            char lastChar = 0;
            for (int i = 0; i < stateBoard.toCharArray().length; i++) {
                char c = stateBoard.toCharArray()[i];
                int color = colorToInt(c);
                if (stateHand[color] > 0 && c != lastChar) {
                    String zuma = zuma(stateBoard.substring(0, i) + c + stateBoard.substring(i), i);
                    if (zuma.equals("")) {
                        return stateTime +1;
                    }
                    stateHand[color]--;
                    queue.offer(new State(zuma, stateTime + 1 , stateHand));
                    stateHand[color]++;
                }
                lastChar = c;
            }
        }
        return -1;
    }

    private String zuma(String in, int index) {
        char[] charArray = in.toCharArray();
        char c = charArray[index];
        int pre = index;
        int suf = index;
        while (pre - 1 >= 0 && charArray[pre - 1] == charArray[index]) {
            pre--;
        }
        while (suf + 1 < in.length() && charArray[suf + 1] == charArray[index]) {
            suf++;
        }
        if (suf - pre >= 2) {
            String next = in.substring(0, pre) + in.substring(suf + 1);
            if (next.equals("")) {
                return next;
            }
            return zuma(next, pre > 0? pre - 1: pre);
        }
        return in;
    }

    private static class State {

        public State(String board, int time, int[] hand) {
            this.board = board;
            this.time = time;
            this.hand = Arrays.copyOf(hand, 5);
        }

        String board;

        int time;

        int[] hand;

        public String getBoard() {
            return board;
        }

        public void setBoard(String board) {
            this.board = board;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int[] getHand() {
            return hand;
        }

        public void setHand(int[] hand) {
            this.hand = hand;
        }
    }

    private int colorToInt(char c) {

        if (c == 'R') {
            return 0;
        }
        if (c == 'Y') {
            return 1;
        }
        if (c == 'B') {
            return 2;
        }
        if (c == 'G') {
            return 3;
        }
        if (c == 'W') {
            return 4;
        }
        return -1;

    }
}
