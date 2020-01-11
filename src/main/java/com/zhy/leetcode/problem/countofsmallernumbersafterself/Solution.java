package com.zhy.leetcode.problem.countofsmallernumbersafterself;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Solution {
    public List<Integer> countSmaller(int[] nums) {

        ArrayList<Integer> reverseResult = new ArrayList<>();

        Tree tree = new Tree();

        for (int i = nums.length - 1; i >= 0; i--) {
            reverseResult.add(tree.smallerNum(nums[i]));
            tree.insert(nums[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = reverseResult.size() - 1; i >= 0; i--) {
            result.add(reverseResult.get(i));
        }

        return result;
    }

    private class Tree {

        TreeNode root = null;

        public void insert(int value) {
            if (root == null) {
                root = new TreeNode(value, null);
            } else {
                TreeNode cur = root;
                TreeNode last = null;
                while (cur != null) {
                    last = cur;
                    if (value > cur.value) {
                        cur = cur.right;
                    } else if (value < last.value) {
                        cur = cur.left;
                    } else {
                        break;
                    }
                }
                if (value > last.value) {
                    last.right = new TreeNode(value, last);
                } else if (value < last.value) {
                    last.left = new TreeNode(value, last);
                } else {
                    last.number++;
                }
            }
        }

        public int smallerNum(int value) {
            return smallerNum(root, value);
        }

        public int smallerNum(TreeNode treeNode, int value) {
            if (treeNode == null) {
                return 0;
            } else {
                if (value > treeNode.value) {
                    return count(treeNode.left) + treeNode.number + smallerNum(treeNode.right, value);
                } else {
                    return smallerNum(treeNode.left, value);
                }

            }
        }

        public int count(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            return count(treeNode.left) + count((treeNode.right)) + treeNode.number;
        }
    }

    private static class TreeNode {

        public TreeNode(int value, TreeNode parent) {
            this.value = value;
            this.parent = parent;
            this.number = 1;
        }

        public int value;

        public int number;

        public TreeNode parent;

        public TreeNode left;

        public TreeNode right;


    }
}
