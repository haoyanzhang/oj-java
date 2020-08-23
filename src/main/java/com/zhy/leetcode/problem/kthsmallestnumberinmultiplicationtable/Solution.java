package com.zhy.leetcode.problem.kthsmallestnumberinmultiplicationtable;

class Solution {

    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(m, n, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int m, int n, int val, int k) {
        int res = 0;
        for (int i = 1; i <= val && i <= m; i++) {
            res += Math.min(val / i, n);
        }
        return k <= res;
    }

}
