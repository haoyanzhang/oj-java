package com.zhy.leetcode.contest.biweeklycontest19.jumpgameIV;

import java.util.*;

class Solution {
    public int minJumps(int[] arr) {

        if (arr.length <= 1) {
            return 0;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }

        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        result[result.length - 1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(result.length - 1);

        while (!queue.isEmpty()) {

            Integer id = queue.poll();
            if (id == 1) {
                return result[id] + 1;
            }
            if (id < result.length - 1 && result[id + 1] == -1) {
                result[id + 1] = result[id] + 1;
                queue.offer(id + 1);
            }
            if (id > 1 && result[id - 1] == -1) {
                result[id - 1] = result[id] + 1;
                queue.offer(id - 1);
            }
            if (map.containsKey(arr[id])) {
                List<Integer> ids = map.get(arr[id]);
                for (Integer nextId : ids) {
                    if (nextId == 0) {
                        return result[id] + 1;
                    }
                    if (result[nextId] == -1) {
                        result[nextId] = result[id] + 1;
                        queue.offer(nextId);
                    }
                }
            }
        }

        return 0;


    }


}