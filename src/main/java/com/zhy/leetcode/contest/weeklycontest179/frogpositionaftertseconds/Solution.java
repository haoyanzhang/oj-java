package com.zhy.leetcode.contest.weeklycontest179.frogpositionaftertseconds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.get(edge[0]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(edge[0], list);
            }
            list.add(edge[1]);

            List<Integer> list2 = map.get(edge[1]);
            if (list2 == null) {
                list2 = new ArrayList<>();
                map.put(edge[1], list2);
            }
            list2.add(edge[0]);
        }
        return dfs(1, t, target, map, visited);
    }

    private static double dfs(int current, int t, int target, Map<Integer, List<Integer>> edges, boolean[] visited){

        if (t == 0) {
            if (current == target) {
                return 1;
            } else {
                return 0;
            }
        }
        List<Integer> nexts = edges.get(current);
        if (nexts == null) {
            if (current == target) {
                return 1;
            } else {
                return 0;
            }
        }
        List<Integer> collect = nexts.stream().filter(next -> !visited[next]).collect(Collectors.toList());
        if (collect.isEmpty()) {
            if (current == target) {
                return 1;
            } else {
                return 0;
            }
        }

        double result = 0;
        double single = 1D / collect.size();
        for (Integer integer : collect) {
            visited[integer] = true;
            double dfs = dfs(integer, t - 1, target, edges, visited);
            visited[integer] = false;
            result += single * dfs;
        }
        return result;
    }

}
