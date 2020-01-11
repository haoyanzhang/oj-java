package com.zhy.leetcode.problem.superwashingmachines;

import java.util.Arrays;

/**
 * @author zhanghaoyan
 */



class Solution {
    public int findMinMoves(int[] machines) {
        int sum = Arrays.stream(machines).sum();
        if (sum % machines.length != 0) {
            return  -1;
        }
        int avg = sum / machines.length;

        int res = 0;
        int left = 0;
        int[] leftZero = new int[machines.length];
        int[] rightZero = new int[machines.length];
        for (int i = 0; i < machines.length; i++) {
            if (machines[i] == 0) {
                int zero = 1;
                for (int j = i + 1; j < machines.length; j++) {
                    leftZero[j] = zero;
                    if (machines[j] == 0) {
                        zero++;
                    } else {
                        break;
                    }
                }
                for (int j = Math.min(i + zero - 1, machines.length - 1); j >= i - 1 && j >= 0; j--) {
                    rightZero[j] = zero - j + i -1;
                }
                i += zero;
            }
        }


        for (int i = 0; i < machines.length; i++) {
            int toMove = machines[i] - avg;
            int right = left + toMove;

            if (right > 0 && left > 0) {
                res = Math.max(Math.max(res, right), left + leftZero[i]);
            } else if (right < 0 && left < 0) {
                res = Math.max(Math.max(res, - right + rightZero[i]), - left);
            } else if(toMove > 0) {
                res = Math.max(res, toMove);
            } else {
                res = Math.max(Math.max(res
                        , right >= 0? right: - right + rightZero[i])
                        , left > 0? left + leftZero[i]: -left);
            }

            left = right;
        }

        return res;

    }
}