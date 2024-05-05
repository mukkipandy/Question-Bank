package com.interview.gs;

public class Median_Of_SortedArray {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 5, 8, 9 };
		int[] nums2 = { 7, 10 };
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.print(median);
	}

	// 1, 2, 2, 5, 7, 8, 9, 10

	private static int p1 = 0, p2 = 0;

	// Get the smaller value between nums1[p1] and nums2[p2] and move the pointer
	// forwards.

	private static int getMin(int[] nums1, int[] nums2) {
		if (p1 < nums1.length && p2 < nums2.length) {
			return nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
		} else if (p1 < nums1.length) {
			return nums1[p1++];
		} else if (p2 < nums2.length) {
			return nums2[p2++];
		}
		return -1;
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if ((m + n) % 2 == 0) {
			for (int i = 0; i < (m + n) / 2 - 1; ++i) {
				int tmp = getMin(nums1, nums2);
			}
			return (double) (getMin(nums1, nums2) + getMin(nums1, nums2)) / 2;
		} else {
			for (int i = 0; i < (m + n) / 2; ++i) {
				int tmp = getMin(nums1, nums2);
			}
			return getMin(nums1, nums2);
		}
	}

}
