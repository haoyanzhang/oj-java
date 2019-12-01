package com.zhy.leetcode.problem.palindromepartitioningII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanghaoyan
 */
class Solution {

    public int minCut(String s) {
        boolean[] reached = new boolean[s.length()];

        Queue<QueueInfo> queueInfos = new LinkedList<>();
        queueInfos.offer(new QueueInfo(0,0));

        QueueInfo queueInfo;
        while ((queueInfo = queueInfos.poll()) != null) {
            for (int i = queueInfo.curPos; i < s.length(); i++) {
                if (!reached[i] && isPalindrome(s, queueInfo.curPos, i)) {
                    reached[queueInfo.curPos] = true;
                    if (i == s.length() - 1) {
                        return queueInfo.getCutTime();
                    }
                    queueInfos.offer(new QueueInfo(queueInfo.getCutTime() + 1, i + 1));
                }
            }
        }
        return -1;
    }

    private boolean isPalindrome(String s, int from, int to) {
        if (from == to) {
            return true;
        }
        char[] chars = s.toCharArray();
        while (to > from) {
            if (chars[from] == chars[to]) {
                from++;
                to--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static class QueueInfo {

        public QueueInfo(int cutTime, int curPos) {
            this.cutTime = cutTime;
            this.curPos = curPos;
        }

        private int cutTime;

        private int curPos;

        public int getCutTime() {
            return cutTime;
        }

        public void setCutTime(int cutTime) {
            this.cutTime = cutTime;
        }

        public int getCurPos() {
            return curPos;
        }

        public void setCurPos(int curPos) {
            this.curPos = curPos;
        }
    }
}
