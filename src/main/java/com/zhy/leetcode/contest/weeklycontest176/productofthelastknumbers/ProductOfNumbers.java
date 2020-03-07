package com.zhy.leetcode.contest.weeklycontest176.productofthelastknumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class ProductOfNumbers {

    List<Integer> product = new ArrayList<>();
    TreeSet<Integer> zeros = new TreeSet<>();

    public void add(int num) {
        if (product.isEmpty()) {
            product.add(num);
        } else if (product.get(product.size() - 1) == 0) {
            zeros.add(product.size() - 1);
            product.add(num);
        } else {
            product.add(product.get(product.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int end = product.size() - 1;
        int start = product.size() - k - 1;
        if (zeros.subSet(start, false, end, true).size() > 0) {
            return 0;
        }
        Integer lastProduct = product.get(end);
        Integer p;
        if (start >= 0) {
            p = product.get(start);
        } else {
            p = 1;
        }

        return p == 0? lastProduct: lastProduct / p;
    }
}