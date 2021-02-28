package week3;

import java.util.Arrays;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        int p1 = 0;
        int p2 = 0;
        int length = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[] res = new int[length];
        while ((p1 < nums1.length) && (p2 < nums2.length)) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                res[count] = nums1[p1];
                count++;
                p1++;
                p2++;
            }
        }
        return Arrays.copyOf(res, count);
    }
}
