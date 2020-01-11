package com.zhy.leetcode.problem.ipo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        ArrayList<Project> projects = new ArrayList<>(Profits.length);
        for (int i = 0; i < Profits.length; i++) {
            projects.add(new Project(Profits[i], Capital[i]));
        }
        projects.sort(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {

                return o1.capital - o2.capital;
            }
        });

        int result = W;
        int pos = 0;

        Queue<Project> queue = new PriorityQueue<>(new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o2.profit - o1.profit;
            }
        });

        for (int i = 0; i < k; i++) {
            while (pos < projects.size() && projects.get(pos).capital <= result) {
                queue.add(projects.get(pos));
                pos++;
            }

            if (queue.isEmpty()) {
                return result;
            }
            result += queue.poll().getProfit();
        }

        return result;

    }

    private static class Project {

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        int profit;

        int capital;

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public int getCapital() {
            return capital;
        }

        public void setCapital(int capital) {
            this.capital = capital;
        }
    }
}
