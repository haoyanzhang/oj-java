package com.zhy.leetcode.problem.reconstructitinerary;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {


        Map<String, List<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                map.get(ticket.get(0)).add(ticket.get(1));
            } else {
                ArrayList<String> strings = new ArrayList<>();
                strings.add(ticket.get(1));
                map.put(ticket.get(0), strings);
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            Collections.sort(stringListEntry.getValue());
        }


        List<String> res = new ArrayList<String>();
        dfs("JFK", map, res);
        Collections.reverse(res);
        return res;

    }

    private void dfs(String string, Map<String, List<String>> map, List<String> res) {
        if(map.get(string)== null) {res.add(string);return ;}
        Iterator<String> ite = map.get(string).iterator();
        while (ite.hasNext()) {
            String des = ite.next();
            ite.remove();
            dfs(des,map,res);

        }
        res.add(string);
    }
}
