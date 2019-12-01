package com.zhy.leetcode.problem.wordbreakII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghaoyan
 */
class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        if (s.equals("")) {
            return new ArrayList<>();
        }

        char[] charArray = s.toCharArray();

        Node root = buildTree(wordDict);

        List<ResultBuilder>[] resultBuilders = new List[s.length()];

        for (int i = 0; i < charArray.length; i++) {

            if (i != 0 && resultBuilders[i-1] == null) {
                continue;
            }

            Node cur = root;
            for (int j = i; j < charArray.length; j++) {

                if ((cur = cur.getChild(charArray[j])) != null) {
                    String value;
                    if ((value = cur.getValue()) != null) {
                        if (resultBuilders[j] == null) {
                            resultBuilders[j] = new ArrayList<>();
                        }
                        if (i == 0) {
                            resultBuilders[j].add(new StartResultBuilder(value));
                        } else {
                            resultBuilders[j].add(new ResultBuilder(resultBuilders[i - 1], value));
                        }
                    }
                } else {
                    break;
                }
            }
        }

        List<ResultBuilder> word = resultBuilders[resultBuilders.length - 1];

        if(word == null) {
            return new ArrayList<>();
        }

        return word.stream().flatMap(resultBuilder -> {
            return resultBuilder.build().stream();
        }).collect(Collectors.toList());

    }



    private Node buildTree(List<String> wordDict) {

        Node root = new Node();

        for (String s : wordDict) {
            char[] chars = s.toCharArray();
            Node cur = root;
            for (char aChar : chars) {
                cur = cur.ensure(aChar);
            }
            cur.setValue(s);
        }

        return root;
    }

    private static class Node {

        private Node[] next = new Node[26];

        private String value;

        public Node ensure(char c) {
            if (next[c - 'a'] == null) {
                next[c - 'a'] = new Node();
            }
            return next[c - 'a'];
        }

        public Node getChild(char c) {
            return next[c - 'a'];
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private class ResultBuilder {

        public ResultBuilder(List<ResultBuilder> resultBuilders, String value) {
            this.resultBuilders = resultBuilders;
            this.value = value;
        }

        protected List<ResultBuilder> resultBuilders;

        protected String value;

        protected List<StringBuilder> toStringBuilders() {
            return resultBuilders.stream()
                    .flatMap(resultBuilder -> resultBuilder.toStringBuilders().stream())
                    .map(stringBuilder -> stringBuilder.append(" ").append(value))
                    .collect(Collectors.toList());
        }

        public List<String> build() {
            return toStringBuilders().stream().map(StringBuilder::toString).collect(Collectors.toList());
        }

    }

    private class StartResultBuilder extends ResultBuilder {

        public StartResultBuilder(String value) {
            super(null, value);
        }

        @Override
        protected List<StringBuilder> toStringBuilders() {
            ArrayList<StringBuilder> res = new ArrayList<>();
            res.add(new StringBuilder(value));
            return res;
        }
    }
}