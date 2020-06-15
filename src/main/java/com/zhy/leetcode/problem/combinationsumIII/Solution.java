package com.zhy.leetcode.problem.combinationsumIII;


import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> dfs(int i, List<Integer> cur, int k, int n) {
        if (k == 0 && n == 0) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(cur));
            return res;
        }
        if (k <= 0 || i == 0) {
            return new ArrayList<>();
        }
        cur.add(i);
        List<List<Integer>> result = dfs(i - 1, cur, k - i, n - 1);
        cur.remove(cur.size() - 1);
        result.addAll(dfs(i - 1, cur, k , n));
        return result;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        return dfs(9, new ArrayList<>(), n, k);

    }

}