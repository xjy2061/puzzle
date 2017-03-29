package org.xjy.java.puzzle;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
        int l = m + n;
        int index1 = l / 2;
        int index2 = -1;
        if (l % 2 == 0) {
        	index1--;
        	index2 = index1 + 1;
        }
        int i = 0;
        int j = 0;
        int p = 0;
        double median = 0;
        while (i < m || j < n) {
            int current;
            if (j >= n || (i < m && nums1[i] <= nums2[j])) {
                current = nums1[i];
                i++;
            } else {
                current = nums2[j];
                j++;
            }
            if (p == index1) {
                median = current;
                if (index2 == -1) {
                	break;
                }
            }
            if (p == index2) {
                median = (median + current) / 2;
                break;
            }
            p++;
        }
        return median;
    }
	
	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
	}
}
