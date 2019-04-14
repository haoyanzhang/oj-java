package com.zhy.leetcode.problem.generateparentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0);
    }

    public List<String> generateParenthesis(int n, int m) {
        if (n == 1) {
            ArrayList<String> result = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("()");
            while (m > 0) {
                stringBuilder.append(")");
                m--;
            }
            result.add(stringBuilder.toString());
            return result;
        } else {
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i <= m + 1; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("(");
                for (int j = 0; j< i; j++) {
                    stringBuilder.append(")");
                }
                String prefix = stringBuilder.toString();
                List<String> list = generateParenthesis(n - 1, m + 1 - i);
                for (String s : list) {
                    result.add(prefix + s);
                }
            }
            return result;
        }
    }
}