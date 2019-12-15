package com.zhy.leetcode.problem.serializeanddeserializebinarytree;

import com.zhy.leetcode.problem.node.TreeNode;

/**
 * @author zhanghaoyan
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return new StringBuilder("{").append(root.val).append(",").append(serialize(root.left)).append(".").append(serialize(root.right)).append("}").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String s = data.substring(1, data.length() - 1);
        int count = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (count == 0 && chars[i] == ',') {
                firstIndex = i;
            } else if (count == 0 && chars[i] == '.') {
                secondIndex = i;
                break;
            } else if (chars[i] == '{') {
                count++;
            } else if (chars[i] == '}') {
                count--;
            }
        }
        TreeNode treeNode = new TreeNode(Integer.valueOf(s.substring(0, firstIndex)));
        treeNode.left = deserialize(s.substring(firstIndex + 1, secondIndex));
        treeNode.right = deserialize(s.substring(secondIndex + 1));
        return treeNode;
    }
}
