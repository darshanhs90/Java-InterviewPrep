package May2021PrepLeetcode;

public class _0004MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 0, 0 }, new int[] { 0, 0 }));
		System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 1 }));
		System.out.println(findMedianSortedArrays(new int[] { 2 }, new int[] {}));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int sumLength = nums1.length + nums2.length;
		int leftLimit = 0, rightLimit = 0;
		boolean hasDoubleMedian = false;
		if (sumLength % 2 == 0) {
			hasDoubleMedian = true;
			leftLimit = sumLength / 2 - 1;
			rightLimit = sumLength / 2;
		} else {
			leftLimit = sumLength / 2;
			rightLimit = sumLength / 2;
		}

		int leftVal = 0, rightVal = 0, leftIndex = 0, rightIndex = 0, index = 0;

		while (index <= rightLimit) {
			int val = 0;

			if (leftIndex < nums1.length && rightIndex < nums2.length) {
				if (nums1[leftIndex] < nums2[rightIndex]) {
					val = nums1[leftIndex];
					leftIndex++;
				} else {
					val = nums2[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < nums1.length) {
				val = nums1[leftIndex];
				leftIndex++;
			} else {
				val = nums2[rightIndex];
				rightIndex++;
			}

			if (index == leftLimit) {
				leftVal = val;
			} else if (index == rightLimit) {
				rightVal = val;
				break;
			}
			index++;
		}
		return hasDoubleMedian ? (leftVal + rightVal) / (double) 2 : leftVal;
	}

}
