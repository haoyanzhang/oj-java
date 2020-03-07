package com.zhy.leetcode.problem.smallestsufficientteam;

import java.util.*;

class Solution {


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        HashMap<String, Integer> map = new HashMap<>();

        int target = 0;

        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], 1 << i);
            target |= (1 << i);
        }


        int[] skills = new int[people.size()];

        Set<Integer> exist = new HashSet<>();

        for (int i = 0; i < people.size(); i++) {
            List<String> strings = people.get(i);
            int skill = 0;
            for (String string : strings) {
                skill |= map.get(string);
            }
            exist.add(skill);
            skills[i] = skill;
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < skills.length; i++) {
            Node node = new Node(i, skills[i]);
            queue.offer(node);
            if (skills[i] == target) {
                return node.result();
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < people.size(); i++) {
                if ((node.skills | skills[i]) != node.skills) {
                    Node newNode = node.add(i, skills[i]);
                    if (newNode.skills == target) {
                        return newNode.result();
                    }
                    if (!exist.contains(newNode.skills)) {
                        exist.add(newNode.skills);
                        queue.offer(newNode);
                    }
                }
            }
        }
        return new int[0];
    }

    private static class Node {

        public Node(int index, int skill) {
            this.skills = skill;
            people = new ArrayList<>();
            people.add(index);
        }

        private Node(List<Integer> people, int skills) {
            this.skills |= skills;
            this.people = new ArrayList<>();
            this.people.addAll(people);
        }

        public Node add(int index , int skill) {
            Node node = new Node(people, skills);
            node.people.add(index);
            node.skills |= skill;
            return node;
        }

        public int[] result() {
            int[] ints = new int[people.size()];
            for (int i = 0; i < people.size(); i++) {
                ints[i] = people.get(i);
            }
            return ints;
        }

        public List<Integer> people;

        public int skills;
    }
}
