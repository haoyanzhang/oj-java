package com.zhy.leetcode.contest.weeklycontest175.tweetcountsperfrequency;

import java.util.*;

class TweetCounts {

    Map<String, TreeSet<Integer>> map = new HashMap<>();

    public TweetCounts() {

    }

    public void recordTweet(String tweetName, int time) {
        TreeSet<Integer> set;
        if (map.containsKey(tweetName)) {
            set = map.get(tweetName);
        } else {
            set = new TreeSet<>();
            map.put(tweetName, set);
        }
        set.add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval = freq.equals("minute")? 60: freq.equals("hour")? 60 * 60: 60 * 60 * 24;
        if (!map.containsKey(tweetName)) {
            return new ArrayList<>();
        }
        TreeSet<Integer> set = map.get(tweetName);
        int start = startTime;
        int end = start + interval;
        ArrayList<Integer> reuslt = new ArrayList<>();
        while (end < endTime + 1) {
            reuslt.add(set.subSet(start, true, end, false).size());
            start = end;
            end = end + interval;
        }
        reuslt.add(set.subSet(start, true, endTime + 1, false).size());
        return reuslt;
    }
}

