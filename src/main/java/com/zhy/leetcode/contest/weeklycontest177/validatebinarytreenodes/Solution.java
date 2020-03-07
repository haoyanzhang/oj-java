package com.zhy.leetcode.contest.weeklycontest177.validatebinarytreenodes;

import java.util.Arrays;
import java.util.Set;

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] parent = new int[leftChild.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] == -1) {
                continue;
            }
            if (parent[leftChild[i]] == -1) {
                parent[leftChild[i]] = i;
            } else {
                return false;
            }
        }
        for (int i = 0; i < rightChild.length; i++) {
            if (rightChild[i] == -1) {
                continue;
            }
            if (parent[rightChild[i]] == -1) {
                parent[rightChild[i]] = i;
            } else {
                return false;
            }
        }
        int root = -1;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }
        if (root == -1) {
            return false;
        }
        return true;
    }

}