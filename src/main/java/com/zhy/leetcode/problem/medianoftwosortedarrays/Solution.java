package com.zhy.leetcode.problem.medianoftwosortedarrays;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        int mid = (count - 1) >> 1;
        return find(nums1, 0, nums2, 0, mid, mid + (count % 2 == 1 ? 0 : 1));
    }

    private double find(int[] nums1, int from1, int[] nums2, int from2, int target1, int target2) {
        if (target1 < 4 && target2 < 4) {
            int[] result = new int[4];
            for (int i = 0; i < 4; i++) {
                if (from1 < nums1.length && from2 < nums2.length) {
                    if (nums1[from1] < nums2[from2]) {
                        result[i] = nums1[from1];
                        from1++;
                    } else {
                        result[i] = nums2[from2];
                        from2++;
                    }
                } else if (from1 < nums1.length) {
                    result[i] = nums1[from1];
                    from1++;
                } else if (from2 < nums2.length) {
                    result[i] = nums2[from2];
                    from2++;
                }
            }
            return ((double)result[target1] + (double)result[target2]) / 2;
        }
        if (from1 == nums1.length) {
            return ((double)nums2[from2 + target1] + (double)nums2[from2 +target2]) / 2;
        } else if (from2 == nums2.length) {
            return ((double)nums1[from1 +target1] + (double)nums1[from1 +target2]) / 2;
        }
        int remove = (target1 - 1) >> 1;
        int mid1 = remove + from1 >= nums1.length ? nums1.length : remove + from1;
        int mid2 = remove + from2 >= nums2.length ? nums2.length : remove + from2;
        if (nums1[mid1 - 1] > nums2[mid2 - 1]) {
            return find(nums1, from1, nums2, mid2, target1 - mid2 + from2, target2 - mid2 + from2);
        } else {
            return find(nums1, mid1, nums2, from2, target1 - mid1 + from1, target2 - mid1 + from1);
        }
    }
}
