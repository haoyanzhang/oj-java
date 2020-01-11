package com.zhy.leetcode.problem.maxsumofrectanglenolargerthank;

public class Application {

    public static void main(String[] args) {
        int[][] ints = new int[3][];
        ints[0] = new int[] {5,-4,-3,4};
        ints[1] = new int[] {-3,-4,4,5};
        ints[2] = new int[] {5,1,5,-4};


        new Solution().maxSumSubmatrix(ints, 10);
    }
}
