package com.zhy.leetcode.problem.textjustification;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int curLength = 0;
        for (String word : words) {
            if (curLength + word.length() + list.size() <= maxWidth) {
                list.add(word);
                curLength += word.length();
            } else {
                result.add(build(list, maxWidth, curLength));
                list.clear();
                list.add(word);
                curLength = word.length();
            }
        }
        result.add(buildLeft(list, maxWidth, curLength));
        return result;
    }

    private String build(List<String> list, int max, int cur) {
        if (list.size() > 1) {
            return buildFull(list, max, cur);
        }
        return buildLeft(list, max, cur);
    }

    private String buildFull(List<String> list, int max, int cur) {
        StringBuilder stringBuilder = new StringBuilder();
        int white = max - cur;
        int size = list.size();
        int whiteLength = white / (size - 1);
        int longerWhiteNum = white - whiteLength * (size - 1);
        for (String s : list) {
            stringBuilder.append(s);
            size--;
            if (size != 0) {
                if (longerWhiteNum > 0) {
                    stringBuilder.append(" ");
                    longerWhiteNum--;
                }
                for (int i = 0; i < whiteLength; i++) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    private String buildLeft(List<String> list, int max, int cur) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
            if (stringBuilder.length() < max) {
                stringBuilder.append(" ");
            }
        }
        while (stringBuilder.length() < max) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
