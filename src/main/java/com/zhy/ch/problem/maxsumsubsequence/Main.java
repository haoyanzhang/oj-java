package com.zhy.ch.problem.maxsumsubsequence;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Deque<Integer> sumQueue = new LinkedList<>();
        Deque<Integer> indexQueue = new LinkedList<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        sumQueue.offer(0);
        indexQueue.offer(-1);
        for (int i = 0; i < n; i++) {
            if (!indexQueue.isEmpty() && indexQueue.peek() + m < i) {
                indexQueue.poll();
                sumQueue.poll();
            }
            sum += scanner.nextInt();
            while (!sumQueue.isEmpty() && sumQueue.peekLast() > sum) {
                indexQueue.pollLast();
                sumQueue.pollLast();
            }
            sumQueue.offer(sum);
            indexQueue.offer(i);
            max = Math.max(max, sum - sumQueue.peek());
        }
        System.out.println(max);
    }
}
