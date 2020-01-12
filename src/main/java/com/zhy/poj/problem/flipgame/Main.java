package com.zhy.poj.problem.flipgame;

import java.util.*;

public class Main {

    private static int[] flips = new int[]{
            51200,
            58368,
            29184,
            12544,
            35968,
            20032,
            10016,
            4880,
            2248,
            1252,
            626,
            305,
            140,
            78,
            39,
            19,
    };

    private static class Item {

        public Item(int cur, int step) {
            this.cur = cur;
            this.step = step;
        }

        public int cur;

        public int step;
    }

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        int input = 0;
        for (int i = 0;  i< 4; i++){
            String c = cin.next();
            for (char c1 : c.toCharArray()) {
                input = (input << 1) | (c1 == 'w'? 1: 0);
            }
        }
        if (input == 0 || input == 65535) {
            System.out.println(0);
            return;
        }
        Queue<Item> queue = new LinkedList<Item>();
        Set<Integer> set = new HashSet<Integer>();
        queue.offer(new Item(input, 0));
        while (!queue.isEmpty()) {
            Item poll = queue.poll();
            for (int flip : flips) {
                int result = poll.cur ^ flip;
                if (result == 0 || result == 65535) {
                    System.out.println(poll.step + 1);
                    return;
                } else {
                    if (!set.contains(result)) {
                        set.add(result);
                        queue.offer(new Item(result, poll.step + 1));
                    }
                }
            }
        }
        System.out.println("Impossible");

    }
}
