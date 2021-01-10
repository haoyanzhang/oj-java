package com.zhy.leetcode.problem.fillingbookcaseshelves;



class Solution {

    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length];
        dp[0] = books[0][1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + books[i][1];
            int w = books[i][0];
            int h = books[i][1];
            int j = i - 1;
            while (j >= 0 && books[j][0] + w <= shelf_width){
                w += books[j][0];
                h = Math.max(h, books[j][1]);
                if (j > 0) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + h);
                } else {
                    dp[i] = Math.min(dp[i], h);
                }
                j--;
            }
        }
        return dp[dp.length - 1];
    }

}