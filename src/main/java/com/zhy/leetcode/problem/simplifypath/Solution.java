package com.zhy.leetcode.problem.simplifypath;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String simplifyPath(String path) {
        List<String> paths = new ArrayList<>();
        int last = -1;
        int pos = 0;
        int index = path.indexOf('/', pos);
        while (index >= 0) {
            if (index - last > 1) {
                String s = path.substring(last + 1, index);
                handler(s, paths);
            }
            last = index;
            pos = index + 1;
            index = path.indexOf('/', pos);
        }
        if (path.length() - last > 1) {
            String s = path.substring(last + 1);
            handler(s, paths);
        }
        if (paths.isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : paths) {
            stringBuilder.append("/")
                    .append(s);
        }
        return stringBuilder.toString();
    }

    private void handler(String s, List<String> paths) {
        if (s.equals(".")) {
            return;
        } else if (s.equals("..")) {
            if (paths.size() > 0) {
                paths.remove(paths.size() - 1);
            }
        } else {
            paths.add(s);
        }
    }
}
