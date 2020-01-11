package com.zhy.leetcode.problem.createmaximumnumber;

class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = null;
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && k - i <= nums2.length) {
                int[] merge = merge(maxNumber(nums1, i), maxNumber(nums2, k - i));
                if (result == null) {
                    result = merge;
                } else {
                    for (int i1 = 0; i1 < result.length; i1++) {
                        if (result[i1] < merge[i1]) {
                            result = merge;
                            break;
                        } else if (result[i1] > merge[i1]) {
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    private int[] maxNumber(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        int pos = 0;

        int drop = nums.length - k;

        for (int num : nums) {
            while (drop > 0 && pos > 0 && result[pos-1] < num) {
                pos--;
                drop--;
            }
            if(pos < result.length) {
                result[pos++] = num;
            } else {
                drop--;
            }
        }

        return result;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int pos = 0;
        int pos1 = 0;
        int pos2 = 0;

        while (pos1 < nums1.length || pos2 < nums2.length) {
            if (pos1 < nums1.length && pos2 < nums2.length && nums1[pos1] > nums2[pos2] || pos2 >= nums2.length) {
                result[pos++] = nums1[pos1++];
            } else if(pos1 < nums1.length && pos2 < nums2.length && nums1[pos1] < nums2[pos2] || pos1 >= nums1.length) {
                result[pos++] = nums2[pos2++];
            } else {
                int t1 = pos1 + 1;
                int t2 = pos2 + 1;
                while (true) {
                    if (t1 == nums1.length || t2 < nums2.length && nums1[t1] < nums2[t2]) {
                        result[pos++] = nums2[pos2++];
                        break;
                    } else if (t2 == nums2.length || t1 < nums1.length && nums2[t2] < nums1[t1])  {
                        result[pos++] = nums1[pos1++];
                        break;
                    } else {
                        t1++;
                        t2++;
                    }
                }
            }
        }
        return result;
    }
}
