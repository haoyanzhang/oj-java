package com.zhy.leetcode.problem.sumroottoleafnumbers;

import com.zhy.leetcode.problem.node.TreeNode;

/**
 * @author zhanghaoyan
 */
class Solution {


    public int sumNumbers(TreeNode root) {
        return travel(root).num;
    }

    private TravelResult travel(TreeNode node) {
        if (node == null) {
            return new TravelResult(0, 0);
        }
        TravelResult leftResult = travel(node.left);
        TravelResult rightResult = travel(node.right);
        int rate = leftResult.rate + rightResult.rate;
        if (rate == 0) {
            rate = 1;
        }
        return new TravelResult(rate * 10, leftResult.num + rightResult.num + node.val * rate);
    }

    private static class TravelResult {

        public TravelResult(int rate, int num) {
            this.rate = rate;
            this.num = num;
        }

        int rate;

        int num;

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
