package com.zhy.leetcode.problem.wordladderII;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhanghaoyan
 */
class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Boolean[][] data = new Boolean[wordList.size()][wordList.size()];

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < i; j++) {
                data[i][j] = data[j][i] = canChange(wordList.get(i), wordList.get(j));
            }
        }

        int endId = wordList.indexOf(endWord);

        if (endId < 0) {
            return new ArrayList<>();
        }

        Queue<Integer> queue = new LinkedList<>();

        Integer[] lengths = new Integer[wordList.size()];
        List<Integer>[] froms = new List[wordList.size()];
        for (int i = 0; i < froms.length; i++) {
            froms[i] = new ArrayList<>();
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (canChange(beginWord, wordList.get(i))) {
                queue.offer(i);
                lengths[i] = 1;
                froms[i].add(-1);
            }
        }

        if (queue.isEmpty()) {
            return new ArrayList<>();
        }

        Integer current = null;
        while ((current = queue.poll()) != null) {
            if (lengths[endId] != null && lengths[endId] < lengths[current]) {
                break;
            }
            for (int i = 0; i < data.length; i++) {
                if (current == i) {
                    continue;
                }
                if (data[current][i]) {
                    if (lengths[i] == null) {
                        lengths[i] = lengths[current] + 1;
                        froms[i].add(current);
                        queue.offer(i);
                    } else {
                        if (lengths[i].equals(lengths[current] + 1)) {
                            froms[i].add(current);
                        }
                    }
                }
            }
        }

        if (lengths[endId] == null) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        Queue<List<Integer>> resultQueue = new LinkedList<>();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(endId);
        resultQueue.offer(l);

        List<Integer> cur = null;
        while ((cur = resultQueue.poll()) != null) {
            Integer last = cur.get(cur.size() - 1);
            for (Integer integer : froms[last]) {
                if (integer == -1) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(beginWord);
                    for (int i = cur.size() - 1; i >= 0; i--) {
                        list.add(wordList.get(cur.get(i)));
                    }
                    result.add(list);
                } else {
                    ArrayList<Integer> list = new ArrayList<>(cur);
                    list.add(integer);
                    resultQueue.offer(list);
                }
            }
        }

        return result;
    }

    private boolean canChange(String a, String b) {
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();

        int diff = 0;

        for (int i = 0; i < aCharArray.length; i++) {
            if (aCharArray[i] != bCharArray[i]) {
                diff++;
                if (diff >= 2) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}