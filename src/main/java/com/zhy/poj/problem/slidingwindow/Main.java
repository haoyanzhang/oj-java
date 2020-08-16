package com.zhy.poj.problem.slidingwindow;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        Deque<Data> queue1 = new ArrayDeque<Data>();
        ArrayList<Integer> list1 = new ArrayList<Integer>(n);
        Deque<Data> queue2 = new ArrayDeque<Data>();
        ArrayList<Integer> list2 = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            Data data = new Data(input, i);
            while (!queue1.isEmpty() && queue1.peekLast().value >= input) {
                queue1.pollLast();
            }
            if (!queue1.isEmpty() && queue1.peek().index + w <= i) {
                queue1.poll();
            }
            queue1.offer(data);
            if (i >= w - 1) {
                list1.add(queue1.peek().value);
            }
            while (!queue2.isEmpty() && queue2.peekLast().value <= input) {
                queue2.pollLast();
            }
            if (!queue2.isEmpty() && queue2.peek().index + w <= i) {
                queue2.poll();
            }
            queue2.offer(data);
            if (i >= w - 1) {
                list2.add(queue2.peek().value);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i));
            if (i != list1.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i));
            if (i != list2.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    private static class Data {
        public int value;
        public int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
