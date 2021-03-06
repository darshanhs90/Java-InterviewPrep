package Mar2021Leetcode;

import java.util.Arrays;

public class _0189RotateArray {

	public static void main(String[] args) {
		rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		rotate(new int[] { -1, -100, 3, 99 }, 2);
		rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
		rotate(new int[] { -1, -100, 3, 99 }, 2);
	}

	public static void rotate(int[] nums, int k) {
		if (k == 0 || nums == null || nums.length < 2)
			return;

		if (k >= nums.length) {
			k = k % nums.length;
		}
		k = nums.length - k-1;
		swap(0, k, nums);
		swap(k + 1, nums.length - 1, nums);
		swap(0, nums.length - 1, nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void swap(int left, int right, int[] nums) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

}
